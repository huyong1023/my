package org.huyong.my.auth.vo;

import lombok.Data;

@Data
public class TokenModel {
    private String accessToken;
    private int expiresIn;
    private String refreshToken;
    private String scope;
}
