package com.src.SpringBootEcom.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
	
	//for validation we need to pass postId also, to check whether it is valid id or not
	@Around("execution(* com.src.SpringBootEcom.service.ProductService.getProductById(..) && args(postId))")
	public Object validationAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
		
		System.out.println("PostId");
		if(postId<0) {
			postId = -postId;
			System.out.println("postID is negative updating it");
		}
		
		Object obj = jp.proceed(new Object[] {postId});
		
		LOGGER.info("postId after Validation : "+jp.getSignature().getName()+" "+postId);
		return obj;
	}
}
