package com.enzo.pbx.res.observer.aspect;

import com.enzo.pbx.res.observer.PbxResourceSubscriber;
import com.enzo.pbx.res.observer.annotation.PbxResourceSubject;
import com.enzo.pbx.res.observer.enums.PbxResourceOperationEnum;
import com.enzo.pbx.res.observer.mapper.ExtensionMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

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

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Pointcut("@annotation(com.enzo.pbx.res.observer.annotation.PbxResourceSubject)")
	public void pointcut() {
	}

	@Around("pointcut() && @annotation(pbxResourceSubject)")
	public Object around(final ProceedingJoinPoint proceedingJoinPoint, PbxResourceSubject pbxResourceSubject) {
		PbxResourceSubject subject = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(PbxResourceSubject.class);
		String[] ids= subject.values();
		List<String> sortedOperations = PbxResourceOperationEnum.sortProcessingOrder(Arrays.asList(ids));
		boolean isAsync = subject.async();

		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		return transactionTemplate.execute(arg0 -> getObject(proceedingJoinPoint, sortedOperations, isAsync));
	}

	private Object getObject(ProceedingJoinPoint proceedingJoinPoint, List<String> sortedOperations, boolean isAsync) {
		Object res = null;
		try {
			res = proceedingJoinPoint.proceed();
			PbxResourceSubscriber.notify(sortedOperations, isAsync, res);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			throw new RuntimeException("Some thing wrong happened");
		}
		return res;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
