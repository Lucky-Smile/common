package com.enzo.pbx.extension.setting.annotation;

import java.lang.annotation.*;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 16:06
 * Company: Zoom
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SettingProperties {

	String key() default "default";

	/**
	 * 1. start -> get extension level setting -> end
	 * 2. start -> get extension level setting -> get global level setting -> end
	 * 3. start -> get extension level setting -> get account level setting -> get global level setting -> end
	 * @return
	 */
	int level() default 1;

}
