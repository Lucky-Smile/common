package com.enzo.pbx.extension.setting.annotation;

import com.enzo.pbx.extension.setting.handler.method.DefaultMethodHandler;

import java.lang.annotation.*;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/11 15:41
 * Company: Zoom
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MethodAround {

	boolean condition() default false;

	Class<?> handle() default DefaultMethodHandler.class;
}
