package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.models.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(org.example.annotations.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint){
        try {
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();

            logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");

            Comment comment = new Comment();
            comment.setAuthor("Laurentiu");
            comment.setText("Some other text!");

            Object [] parameters = {comment};
            Object returnedByMethod = joinPoint.proceed(parameters);

            logger.info("Method executed and returned " + returnedByMethod);

            return "FAILED";
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
