/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.web.user.configuration;

import net.gilangprambudi.spring.boilerplate.web.user.interceptor.LoadTestControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: WebControllerConfiguration.java, v 0.1 2023‐09‐29 12.38 gilang.prambudi Exp $$
 */

@Configuration
public class WebControllerConfiguration implements WebMvcConfigurer {
   @Autowired
   LoadTestControllerInterceptor loadTestControllerInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(loadTestControllerInterceptor);
   }
}