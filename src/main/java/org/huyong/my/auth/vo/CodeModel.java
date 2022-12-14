package org.huyong.my.auth.vo;

import lombok.Data;

@Data
public class CodeModel {

    /** 用户ID */
    private String userId;

    /** 应用ID */
    private String clientId;

    /** 授权范围 */
    private String scope;

    /** 授权码 */
    private String code;
}