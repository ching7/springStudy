package com.cyn.validated;

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
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
// FlagValidatorClass.class 这个类就是验证是否通过
@Constraint(validatedBy = FlagValidator.FlagValidatorClass.class)
public @interface FlagValidator {
    // value就是需要传值的，这里使用数组，即前端传来的值只要这个数组里存在就通过
    int[] value() default {};

    // 参数校验失败的时候返回的默认信息
    String message() default "flag is not found";

    // 分组使用
    Class<?>[] groups() default {};

    // 不知道是啥，反正都有，写上总没错
    Class<? extends Payload>[] payload() default {};

    public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Integer> {

        private FlagValidator constraint;

        // 一般来说如果用到了自定义注解里面的值，从这个初始化方法中给全局变量赋值，方便isValis()方法中使用
        @Override
        public void initialize(FlagValidator constraint) {
            this.constraint = constraint;
        }

        /**
         * 第一个参数value就是接收到的前端的值
         * 第二个参数目前没用到
         * 如果返回true就表示通过，false就表示校验失败，返回默认的信息
         */
        @Override
        public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
            // 如果前端不传值返回false，返回错误异常
            if (value == null) {
                return false;
            }
            // 这个values就是你放在注解上的value数组，即 @FlagValidator(value = {0,1},message = "预约状态参数错误") 这里面的value值
            int[] values = constraint.value();
            // 遍历设定的值，当有一个值等于的话，就放行，否则拒绝放行
            for (int i : values) {
                if (i == value) {
                    return true;
                }
            }
            return false;
        }
    }
}
