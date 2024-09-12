package com.rpc.annotation;

import java.lang.annotation.*;

/**
 * @Author: djc
 * @Date: 2024-09-12-19:49
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface RpcReference {


    String version() default "";
    String group() default "";
}
