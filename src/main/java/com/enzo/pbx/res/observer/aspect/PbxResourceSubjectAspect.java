package com.enzo.pbx.res.observer.aspect;

import com.enzo.pbx.res.observer.PbxResourceSubscriber;
import com.enzo.pbx.res.observer.annotation.PbxResourceSubject;
import com.enzo.pbx.res.observer.enums.PbxResourceOperationEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:26
 * Company: Zoom
 */
@Component
@Aspect
public class PbxResourceSubjectAspect implements Ordered {

	@Pointcut("@annotation(com.enzo.pbx.res.observer.annotation.PbxResourceSubject)")
	public void pointcut() {
	}

	@Around("pointcut() && @annotation(pbxResourceSubject)")
	public Object doAfter(final ProceedingJoinPoint proceedingJoinPoint, PbxResourceSubject pbxResourceSubject) {
		Object res = null;
		PbxResourceSubject subject = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(PbxResourceSubject.class);
		String[] ids= subject.values();
		List<String> sortedOperations = PbxResourceOperationEnum.sortProcessingOrder(Arrays.asList(ids));
		boolean isAsync = subject.async();

		try {
			res = proceedingJoinPoint.proceed();
			PbxResourceSubscriber.notify(sortedOperations, isAsync, res);
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
