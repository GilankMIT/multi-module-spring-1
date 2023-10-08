/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.util.interceptor;

import net.gilangprambudi.spring.boilerplate.common.util.annotation.MethodDigestLog;
import net.gilangprambudi.spring.boilerplate.core.model.holder.MethodDigestContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: MethodDigestLogInterceptor.java, v 0.1 2023‐09‐29 16.36 gilang.prambudi Exp $$
 */
@Aspect
public class MethodDigestLogInterceptor {
    public MethodDigestLogInterceptor(){}

    @Around("@annotation(net.gilangprambudi.spring.boilerplate.common.util.annotation.MethodDigestLog)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        MethodDigestLog logAnnotation = methodSignature.getMethod().getAnnotation(MethodDigestLog.class);
        String className = methodSignature.getDeclaringTypeName();
        String[] classNameSplit = className.split("\\.");
        className = classNameSplit[classNameSplit.length -1];
        String classMethodName = className + "." + methodSignature.getMethod().getName();
        Logger LOGGER = LoggerFactory.getLogger(logAnnotation.logName());
        Object var10 = null;
        try {
            var10 = proceedingJoinPoint.proceed();
        }catch(Exception e){
            LOGGER.error(e.getMessage());
        }finally {
            Object request = proceedingJoinPoint.getArgs()[0];
            if (null != request){
                LOGGER.info("invoke param auto {}", request);
                LOGGER.info("invoke result auto {}", var10.toString());
            }

            LOGGER.info("{} invoke params : {}", classMethodName, MethodDigestContextHolder.getParam());
            LOGGER.info("{} invoke result : {}", classMethodName, MethodDigestContextHolder.getResult());
        }
        return var10;
    }
}