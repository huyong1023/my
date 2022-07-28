package org.huyong.my.constraints;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @Author: huyong03
 * @Date: 2022/6/9 15:27
 * @Description:
 */
public class HelloEJB {
    public static void main(String args[]){


        // Validator を取得
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Bean を作成
        HelloBean bean = new HelloBean("str");

        // バリデーションを実行
        Set<ConstraintViolation<HelloBean>> result = validator.validate(bean);

        // 結果の確認
        System.out.println("size = " + result.size());
        System.out.println("message = " + result.iterator().next().getMessage());
    }
}
