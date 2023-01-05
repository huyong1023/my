package org.huyong.my.spring.rest.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TestDTO {
    @NotBlank
    private Integer num;

    @NotBlank
    private String type;

    @NotBlank
    private String userName;

    @NotBlank
    @Length(min = 6, max = 20)
    private String password;

    @NotNull
    @Email
    private String email;

    @Mobile
    private String mobile;
}
