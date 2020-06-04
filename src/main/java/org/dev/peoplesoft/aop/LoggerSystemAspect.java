package org.dev.peoplesoft.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerSystemAspect {

	@Pointcut("execution (* org.dev.peoplesoft.repository.*.*(..))")
	public void logTransactionInTheBeginingANDENDPointCut()
	{}
	
	@Around("org.dev.peoplesoft.aop.LoggerSystemAspect.logTransactionInTheBeginingANDENDPointCut()")
	public Object logTransactionInTheBeginingANDEND(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("");
		String methodName = proceedingJoinPoint.getSignature().toShortString();

		Object arg[] = proceedingJoinPoint.getArgs();
		for(Object tempO:arg)
		{
			System.out.println(tempO);
		}
		
		System.out.println("=======> Executing @around advice finally on method: "+methodName);
		
		//get begin timestamp
		long startTime = System.currentTimeMillis();
		
		//now, lets execute the method
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get end timestamp
		long endTime = System.currentTimeMillis();

		//compute duration and display it
		System.out.println("=======>Time taken in processing in second is "+(endTime-startTime)/1000.0);
		
		return result;
	}
	
	
	
}
