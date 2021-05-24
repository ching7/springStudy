package com.cyn.validated;

import com.cyn.bean.RoleNum;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-05-21
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) //在方法和属性上面起作用
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidNum100.ValidNum100Class.class)
public @interface ValidNum100 {
    String value() default " ";
    // Class<?> value();

    /**
     * 这三个方法是必须要有的
     */
    String message() default "The input parameter value is not 100 ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class ValidNum100Class implements ConstraintValidator<ValidNum100, String> {
        private List<Object> values = new ArrayList<>();

        @Override
        public void initialize(ValidNum100 constraintAnnotation) {
            String clz = constraintAnnotation.value();
//            Object[] objects = clz.getEnumConstants();
            try {
//                Method method = clz.getMethod("getCode");
//                if (Objects.isNull(method)) {
//                    throw new Exception(String.format("枚举对象{}缺少字段名为code的字段", clz.getName()));
//                }
//                Object value = null;
//                for (Object obj : objects) {
//                    value = method.invoke(obj);
//                    values.add(value);
//                }
                if (clz.equals("100")) {
                    System.out.println("校验成功");
                }
            } catch (Exception e) {
                System.out.println("[处理枚举校验异常]" + e);
            }
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
            return Objects.isNull(value) || values.contains(value);
        }
    }
}
