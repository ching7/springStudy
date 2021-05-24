package com.cyn.validated;

import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-05-24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = IsLeekValidator.class) // 指定我们自定义的校验类
public @interface IsLeek {

    /**
     * 是否强制校验
     *
     * @return 是否强制校验的boolean值
     */
    boolean required() default true;

    /**
     * 校验不通过时的报错信息
     *
     * @return 校验不通过时的报错信息
     */
    String message() default "此用户不是韭零后，无法开户！";

    /**
     * 将validator进行分类，不同的类group中会执行不同的validator操作
     *
     * @return validator的分类类型
     */
    Class<?>[] groups() default {};

    /**
     * 主要是针对bean，很少使用
     *
     * @return 负载
     */
    Class<? extends Payload>[] payload() default {};

}

class IsLeekValidator implements ConstraintValidator<IsLeek, String> {

    // 是否强制校验
    private boolean required;

    @Override
    public void initialize(IsLeek constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            // 名字以"新韭菜"开头的则校验通过
            return !StringUtils.isEmpty(name) && name.startsWith("新韭菜");
        }
        return false;
    }
}