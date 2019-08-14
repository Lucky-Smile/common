package com.enzo.pbx.res.observer;

import com.enzo.pbx.res.observer.annotation.PbxResourceObserver;
import com.enzo.pbx.res.observer.util.ReflectTool;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:02
 * Company: Zoom
 */
@Service
public class PbxResourceObserverBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class<?> clazz = bean.getClass();
		List<Method> methodList = ReflectTool.getObserverMethod(clazz.getDeclaredMethods(), PbxResourceObserver.class);

		for (Method method : methodList) {
			PbxResourceObserver pbxResourceObserver = method.getAnnotation(PbxResourceObserver.class);
			String id = pbxResourceObserver.value();

			PbxResourceSubscriber.addMethod(id, method, bean);
		}

		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
