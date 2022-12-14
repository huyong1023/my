package org.huyong.my.auth.vo;

import lombok.Data;

@Data
public class GetTokenRequest {
    private String grantType;
    private String clientId;
    private String clientSecret;
    private String code;
}
