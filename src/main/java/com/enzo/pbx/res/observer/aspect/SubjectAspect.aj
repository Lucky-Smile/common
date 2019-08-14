package com.enzo.pbx.res.observer.aspect;

import com.enzo.pbx.res.observer.annotation.Subject;
import com.enzo.pbx.res.observer.Subscriber;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:26
 * Company: Zoom
 */
@Component
@Aspect
public class SubjectAspect implements Ordered {

	@Pointcut("@annotation(com.enzo.pbx.res.observer.annotation.Subject)")
	public void pointcut() {
	}

	@Around("pointcut() && @annotation(subject)")
	public Object doAfter(final ProceedingJoinPoint proceedingJoinPoint, Subject subject) {
		Object res = null;
		String id = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(Subject.class).value();

		try {
			res = proceedingJoinPoint.proceed();
			Subscriber.notify(id, res);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		return res;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
