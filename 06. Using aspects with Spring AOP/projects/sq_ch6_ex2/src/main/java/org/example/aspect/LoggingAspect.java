package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.example.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint){
        try {
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();

            logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
            Object returnedByMethod = joinPoint.proceed();

            return returnedByMethod;//If you return nothing, the call to `publishComment` in Main will return null
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
