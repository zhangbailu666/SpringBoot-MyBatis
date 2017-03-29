package com.qbian.common.annotation;

import java.lang.annotation.*;

/**
 * Created by Qbian on 2017/3/27.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Now {
    String type() default "C";
}
