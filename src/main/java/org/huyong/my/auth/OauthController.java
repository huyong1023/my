package org.huyong.my.auth;

import org.huyong.my.auth.vo.CodeModel;
import org.huyong.my.auth.vo.GetTokenRequest;
import org.huyong.my.auth.vo.TokenModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class OauthController {

    private static final Map<String, String> basicAppMap = new HashMap<>(16);


    static {
        basicAppMap.put("clientId", "209e33db-154b-4fda-a93d-16f124413da2");
        basicAppMap.put("redirectUri", "www.baidu.com");
        basicAppMap.put("scope", "sex,age,nickName");
    }

    @GetMapping("/authorize")
    public void authorize(@RequestParam("response_type") String responseType, @RequestParam("client_id") String clientId,
                          @RequestParam("redirect_uri") String redirectUri, String scope) {
        // 基本信息检验
        preCheck(responseType, clientId, redirectUri);

        // 权限申请检验
        preCheckScope(scope);

        // todo 重定向到授权页面

    }


    @PostMapping("/confirm")
    public void confirm(String scope, HttpServletResponse response) throws IOException {
        // 生成code
        String code = generateCode(basicAppMap.get("clientId"), basicAppMap.get("userId"), scope);

        // 重定向到业务系统
        response.sendRedirect(basicAppMap.get("redirectUri") + "?code=" + code);
    }



    @PostMapping("/token")
    public TokenModel getToken(@RequestBody GetTokenRequest getTokenRequest) {
        // 获取令牌前置检验
        preGetTokenCheck(getTokenRequest);



        // 检验授权码
        checkCode(getTokenRequest.getCode());

        // 生成t访问令牌
        TokenModel tokenModel = generateToken();
        return tokenModel;
    }



    private void preCheck(String responseType, String clientId, String redirectUri) {
        if (!"code".equals(responseType)) {
            throw new RuntimeException("response_type must be code");
        }
        if (!basicAppMap.get("clientId").equals(clientId)) {
            throw new RuntimeException("client_id is wrong");
        }
        if (!basicAppMap.get("redirectUri").equals(redirectUri)) {
            throw new RuntimeException("redirectUri is wrong");
        }
    }


    private void preCheckScope(String scope) {
        List<String> scopeList = Arrays.asList(basicAppMap.get("scope").split(","));
        boolean exist = scopeList.stream().anyMatch(s -> s.equals(scope));
        if (!exist) {
            throw new RuntimeException("权限申请超出规定范围");
        }

    }


    private String generateCode(String clientId, String userId, String scope) {
        CodeModel codeModel = new CodeModel();
        String code = UUID.randomUUID().toString();
        codeModel.setClientId(clientId);
        codeModel.setUserId(userId);
        codeModel.setScope(scope);
        codeModel.setCode(code);
        // todo 存储code信息,比如redis中，同时设置code有效期
        return code;
    }


    private void preGetTokenCheck(GetTokenRequest getTokenRequest) {
        if ("authorization_code".equals(getTokenRequest.getGrantType())) {
            throw new RuntimeException("grant_type is wrong");
        }
        if (!basicAppMap.get("clientId").equals(getTokenRequest.getClientId())) {
            throw new RuntimeException("client_id is wrong");
        }
        if (!basicAppMap.get("client_secret").equals(getTokenRequest.getClientSecret())) {
            throw new RuntimeException("client_secret is wrong");
        }
    }


    private void checkCode(String code) {
        if (!basicAppMap.get("code").equals(code)) {
            throw new RuntimeException("code is wrong");
        }
        // 使用之后立即删除
        basicAppMap.remove("code");

    }

    private TokenModel generateToken() {
        // 获取code信息，比如从redis
        // CodeModel codeModel = getCode;
        TokenModel tokenModel = new TokenModel();
        tokenModel.setAccessToken(UUID.randomUUID().toString());
        tokenModel.setExpiresIn(3600);
        tokenModel.setRefreshToken(UUID.randomUUID().toString());
        // tokenModel.setScope(codeModel.getScope);
        return tokenModel;
    }
}



