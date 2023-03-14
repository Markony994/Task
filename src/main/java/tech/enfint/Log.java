package tech.enfint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class Log
{

    @Around("@annotation(Logging)")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();

        Logging myAnnotation = method.getAnnotation(Logging.class);
        FieldType type = myAnnotation.fieldType();

        if(type == FieldType.ENTRY)
        {
            String name = proceedingJoinPoint.getSignature().getName();
            Object[] args = proceedingJoinPoint.getArgs();

            String stringArgs = "";

            for(Object arg : args)
            {
                stringArgs += arg.toString();
            }

            System.out.println("\nMethod has been run:\nName: " + name + "; args:\n" +
                    (stringArgs.length() > 0 ? stringArgs : "none"));
        }

        Object returnValue = null;

        try
        {
            returnValue = proceedingJoinPoint.proceed();

            if(type == FieldType.EXIT)
            {
                System.out.println("Method finished running successfully: " + returnValue);
            }

        }
        catch (Exception ex)
        {
            if(type == FieldType.ERROR)
            {
                System.out.println("Method finished running with error:\n" + ex);

                throw ex;
            }

        }

        return returnValue;

    }//public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable

//    @Before("execution(* tech.enfint..*.*(..))")
//    public void logRanMethod(JoinPoint joinPoint)
//    {
//        String name = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//
//        String stringArgs = "";
//
//        for(Object arg : args)
//        {
//            stringArgs += arg.toString();
//        }
//
//        System.out.println("\nMethod has been run:\nName: " + name + "; args:\n" +
//                (stringArgs.length() > 0 ? stringArgs : "none"));
//    }
//
//    @AfterReturning(pointcut="execution(* tech.enfint..*.*(..))",
//            returning = "returnValue")
//    public void logSuccessfulMethod(JoinPoint joinPoint, Object returnValue)
//    {
//        System.out.println("Method finished running successfully: " +returnValue);
//    }
//
//    @AfterThrowing(pointcut="execution(* tech.enfint..*.*(..))",
//    throwing = "ex")
//    public void logErrorMethod(JoinPoint joinPoint, Exception ex)
//    {
//        String name = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//
//        System.out.println("Method finished running with error:\n" + ex);
//
//    }

}
