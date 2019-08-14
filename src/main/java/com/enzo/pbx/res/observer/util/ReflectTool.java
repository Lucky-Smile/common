package com.enzo.pbx.res.observer.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:06
 * Company: Zoom
 */
public class ReflectTool {

	public static List<Method> getObserverMethod(Method[] methods, Class<? extends Annotation> annotationClass) {
		List<Method> methodList = new ArrayList<>();

		for (Method method : methods) {
			if (null != method.getAnnotation(annotationClass)) {
				methodList.add(method);
			}
		}

		return methodList;
	}
}
