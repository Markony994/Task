package tech.enfint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging
{

    @Before("execution(* tech.enfint..*.*(..))")
    public void logRanMethod(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        String stringArgs = "";

        for(Object arg : args)
        {
            stringArgs += arg.toString();
        }

        System.out.println("\nMethod has been run:\nName: " + name + "; args:\n" +
                (stringArgs.length() > 0 ? stringArgs : "none"));
    }

    @AfterReturning(pointcut="execution(* tech.enfint..*.*(..))",
            returning = "returnValue")
    public void logSuccessfulMethod(JoinPoint joinPoint, Object returnValue)
    {
        System.out.println("Method finished running successfully: " +returnValue);
    }

    @AfterThrowing(pointcut="execution(* tech.enfint..*.*(..))",
    throwing = "ex")
    public void logErrorMethod(JoinPoint joinPoint, Exception ex)
    {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("Method finished running with error:\n" + ex);

    }

}
