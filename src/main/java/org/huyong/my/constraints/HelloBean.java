package org.huyong.my.constraints;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @Author: huyong03
 * @Date: 2022/6/9 15:27
 * @Description:
 */
public class HelloBean {
    @NotNull
    private String hoge;


    public HelloBean(@NotNull String str){
        this.hoge = str;
    }
}
