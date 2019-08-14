package com.enzo.pbx.res.observer.annotation;

import java.lang.annotation.*;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 16:58
 * Company: Zoom
 */

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PbxResourceObserver {
	String value();
}
