package com.enzo.pbx.res.observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:00
 * Company: Zoom
 */
public class Subscriber {

	public static class MethodHolder {
		Method method;
		Object target;

		public MethodHolder(Method method, Object target) {
			this.method = method;
			this.target = target;
		}

		public Method getMethod() {
			return method;
		}

		public void setMethod(Method method) {
			this.method = method;
		}

		public Object getTarget() {
			return target;
		}

		public void setTarget(Object target) {
			this.target = target;
		}

		public void execute(Object param) {
			try {
				method.invoke(target, param);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}

	static Map<String, List<MethodHolder>> observerMethodMap = new ConcurrentHashMap<>();

	public static void addMethod(String id, Method method, Object target) {
		if (null == observerMethodMap.get(id)) {
			observerMethodMap.put(id, new ArrayList<>());
		}

		observerMethodMap.get(id).add(new MethodHolder(method, target));
	}

	public static void notify(String id, Object param) {
		List<MethodHolder> methodHolders = observerMethodMap.get(id);

		if (null != methodHolders) {
			for (MethodHolder methodHolder : methodHolders) {
				methodHolder.execute(param);
			}
		}
	}
}
