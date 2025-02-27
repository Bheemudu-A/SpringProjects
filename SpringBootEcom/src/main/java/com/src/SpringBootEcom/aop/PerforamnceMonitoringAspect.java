package com.src.SpringBootEcom.aop;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;


@Component
@Aspect
public class PerforamnceMonitoringAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerforamnceMonitoringAspect.class);

	
	@Around("execution(* com.src.SpringBootEcom.service.ProductService.getAllProducts(..))")
	public Object perfomanceMonitoringMethod(ProceedingJoinPoint jp) throws Throwable {
		
		long startTime = System.currentTimeMillis();	
		Object obj = jp.proceed(); 	
		long endTime = System.currentTimeMillis();
		
		LOGGER.info("Time taken : "+ jp.getSignature().getName() +" "+(endTime-startTime)+" milli seconds");
		return obj;
	}
}
