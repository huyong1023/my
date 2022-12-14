package org.huyong.my.auth;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * jwt加解密实现
 *
 * @author zhengsc
 */
@Slf4j
public class TokenUtil {

    private String ISSUER = "companyName"; // 机构

    private String APP_SECRET_KEY = "secret"; // 密钥

    private long MAX_TOKEN_AGE = 1800; // 存活期

    /**
     * 生成userId的accessToken
     *
     * @param userid
     * @return
     */
    public String generateAccessToken(String userid) {
        JSONObject claims = new JSONObject();
        claims.put("iss", ISSUER);
        claims.put("userid", userid);
        String accessToken = sign(claims, APP_SECRET_KEY);
        return accessToken;
    }

    /**
     * 解密程序返回userid
     *
     * @param token
     * @return
     */
    public String verifyToken(String token) {
        String userid = "";
        try {
            String[] splitStr = token.split("\\.");
            String headerAndClaimsStr = splitStr[0] + "." +splitStr[1];
            String veryStr = signHmac256(headerAndClaimsStr, APP_SECRET_KEY);
            // 校验数据是否被篡改
            if (veryStr.equals(splitStr[2])) {
                String header = new String(Base64.decodeBase64(splitStr[0]),"UTF-8");
                JSONObject head = JSONObject.fromObject(header);
                long expire = head.getLong("exp") * 1000L;
                long currentTime = System.currentTimeMillis();
                if (currentTime <= expire){ // 验证accessToken的有效期
                    String claims = new String(Base64.decodeBase64(splitStr[1]),"UTF-8");
                    JSONObject claim = JSONObject.fromObject(claims);
                    userid = (String) claim.get("userid");
                }
            }
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }

        return userid;
    }

    /**
     * 组装加密结果jwt返回
     *
     * @param claims
     * @param appSecretKey
     * @return
     */
    private String sign(JSONObject claims, String appSecretKey) {
        String headerAndClaimsStr = getHeaderAndClaimsStr(claims);
        String signed256 = signHmac256(headerAndClaimsStr, appSecretKey);
        return headerAndClaimsStr + "." + signed256;
    }

    /**
     * 拼接请求头和声明
     *
     * @param claims
     * @return
     */
    private String getHeaderAndClaimsStr(JSONObject claims) {
        JSONObject header = new JSONObject();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        header.put("exp", System.currentTimeMillis() + MAX_TOKEN_AGE * 1000L);
        String headerStr = header.toString();
        String claimsStr = claims.toString();
        String headerAndClaimsStr = Base64.encodeBase64URLSafeString(headerStr.getBytes()) + "."
                + Base64.encodeBase64URLSafeString(claimsStr.getBytes());
        return headerAndClaimsStr;
    }

    /**
     * 将headerAndClaimsStr用SHA1加密获取sign
     *
     * @param headerAndClaimsStr
     * @param appSecretKey
     * @return
     */
    private String signHmac256(String headerAndClaimsStr, String appSecretKey) {
        SecretKey key = new SecretKeySpec(appSecretKey.getBytes(), "HmacSHA256");
        String result = null;
        try {
            Mac mac;
            mac = Mac.getInstance(key.getAlgorithm());
            mac.init(key);
            result = Base64.encodeBase64URLSafeString(mac.doFinal(headerAndClaimsStr.getBytes()));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

}