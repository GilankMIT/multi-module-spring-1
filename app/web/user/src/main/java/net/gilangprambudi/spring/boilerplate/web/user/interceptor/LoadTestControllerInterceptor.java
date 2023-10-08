/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.web.user.interceptor;

import net.gilangprambudi.spring.boilerplate.core.model.holder.LoadTestContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: LoadTestControllerInterceptor.java, v 0.1 2023‐09‐29 12.25 gilang.prambudi Exp $$
 */

@Component
@Order(value = 1)
public class LoadTestControllerInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      if(request.getHeader("source-agent") != null &&
         request.getHeader("source-agent").equals("load-test-agent")){
         LoadTestContextHolder.initNewContext(true);
      }
      return true;
   }
}