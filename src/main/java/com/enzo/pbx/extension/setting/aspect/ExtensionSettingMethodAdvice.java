package com.enzo.pbx.extension.setting.aspect;

import com.enzo.pbx.extension.setting.annotation.MethodAround;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/11 16:01
 * Company: Zoom
 */

@Component
@Aspect
public class ExtensionSettingMethodAdvice implements Ordered {

	private static final Logger logger = LoggerFactory.getLogger(ExtensionSettingMethodAdvice.class);

	@Override
	public int getOrder() {
		return 10;
	}

	@Pointcut(value = "@annotation(com.enzo.pbx.extension.setting.annotation.MethodAround)")
	private void pointcut(){
	}

	@AfterReturning(value = "pointcut() && @annotation(methodAround)", returning = "result")
	public Object afterRunning(JoinPoint joinPoint, MethodAround methodAround, Object result){

		if(!methodAround.condition()){
			logger.debug("test condition");
		}

		String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
		Object[] args = joinPoint.getArgs();


		logger.debug("-------afterRunning---------");
		return result;
	}
}
