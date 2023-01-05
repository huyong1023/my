package org.huyong.my.spring.rest.controller;


import org.huyong.my.spring.rest.dto.TestDTO;
import org.huyong.my.spring.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
public class TestController {

    @Autowired
    private TestService testService;


    /**
     * Java API 的规范 JSR303 定义了校验的标准 validation-api ，其中一个比较出名的实现是 hibernate validation。
     * spring validation 是对其的二次封装，常用于 SpringMVC 的参数自动校验，参数校验的代码就不需要再与业务逻辑代码进行耦合了。
     * 对 @PathVariable 和 @RequestParam 参数进行校验需要在入参声明约束的注解。
     * 在 SpringMVC 中，有一个类是 RequestResponseBodyMethodProcessor
     *  用于解析 @RequestBody 标注的参数
     *  处理 @ResponseBody 标注方法的返回值
     * @param num
     * @return
     */
    @GetMapping("/{num}")
    public Integer detail(@PathVariable("num") @Min(1) @Max(20) Integer num) {
        return num * num;
    }

    @GetMapping("/getByEmail")
    public TestDTO getByAccount(@RequestParam @NotBlank @Email String email) {
        TestDTO testDTO = new TestDTO();
        testDTO.setEmail(email);
        return testDTO;
    }


    /**
     * 对 @RequestBody 参数进行校验需要在 DTO 对象中加入校验条件后，再搭配 @Validated 即可完成自动校验。
     * 如果校验失败，会抛出 ConstraintViolationException 异常。
     * 声明约束的方式，注解加到了参数上面，可以比较容易猜测到是使用了 AOP 对方法进行增强。
     *
     * 而实际上 Spring 也是通过 MethodValidationPostProcessor 动态注册 AOP 切面，然后使用 MethodValidationInterceptor 对切点方法进行织入增强。
     * @param testDTO
     */
    @PostMapping("/test-validation")
    public void testValidation(@RequestBody @Validated TestDTO testDTO) {
        this.testService.save(testDTO);
    }


    @PostMapping("/test")
    public Double test(@RequestBody TestDTO testDTO) {
        try {
            Double result = this.testService.service(testDTO);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
