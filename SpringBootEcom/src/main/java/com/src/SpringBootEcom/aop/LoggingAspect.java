package com.src.SpringBootEcom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	
  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

  
  //return type, class-name.method(arguments) (exceution(* *.*(..)))
  //we need to follow above structure while using Before annotation
  
  @Before("execution(* com.src.SpringBootEcom.service.ProductService.*(..))")
  public void logMethodCall(JoinPoint jp) {
	  System.out.println("Data Logged : "+jp.getSignature().getName());
  }
  
  //similar to finally block
  //this will excute after method excutes, it will excute even if there is exception in method, just like finally block
  @After("execution(* com.src.SpringBootEcom.service.ProductService.getAllProducts(..))")
  public void logMethodAftercall(JoinPoint jp) {
	  System.out.println("Method Excuted: "+jp.getSignature().getName());
  }
  
  //similar to catch block
  //this will excute only if there is exception in a method
  @AfterThrowing("execution(*,com.src.SpringBootEcom.service.ProductService.getAllProducts(..))")
  public void logMethodAfterException(JoinPoint jp) {
	  System.out.println("Method has some issues : "+jp.getSignature().getName());
  }
  
  
  //excutes if method succesfully executes
  @AfterReturning("execution(*,com.src.SpringBootEcom.service.ProductService.getAllProducts(..))")
  public void logMethodAfterReturning(JoinPoint jp) {
	  System.out.println("Method has some issues : "+jp.getSignature().getName());
  }
  
}
