package com.enzo.pbx.res.observer;

import com.enzo.pbx.res.observer.annotation.Observer;
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
public class ObserverBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class<?> clazz = bean.getClass();
		List<Method> methodList = ReflectTool.getObserverMethod(clazz.getDeclaredMethods(), Observer.class);

		for (Method method : methodList) {
			Observer observer = method.getAnnotation(Observer.class);
			String id = observer.value();

			Subscriber.addMethod(id, method, bean);
		}

		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
