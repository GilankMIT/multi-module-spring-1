/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.service.integration.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: MetricInterceptor.java, v 0.1 2023‐10‐04 06.50 gilang.prambudi Exp $$
 */
public class MetricInterceptor implements MethodInterceptor {
   private static final Logger LOGGER = LoggerFactory.getLogger(MetricInterceptor.class);
   @Override
   public Object invoke(MethodInvocation methodInvocation) throws Throwable {
      LOGGER.info("this is invoked by MetricInterceptor");

      return methodInvocation.proceed();
   }
}