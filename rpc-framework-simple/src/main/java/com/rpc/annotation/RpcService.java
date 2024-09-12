package com.rpc.annotation;

import java.lang.annotation.*;

/**
 * @Author: djc
 * @Date: 2024-09-12-19:56
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface RpcService {
    String version() default "";
    String group() default "";
}
