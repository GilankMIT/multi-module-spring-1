/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.application;

import net.gilangprambudi.spring.boilerplate.common.util.interceptor.MethodDigestLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: SpringBoilerplateConfiguration.java, v 0.1 2023‐09‐28 00.04 gilang.prambudi Exp $$
 */

@Configuration
@ComponentScan(basePackages = {"net.gilangprambudi.spring.boilerplate"})
@EnableAspectJAutoProxy
public class SpringBoilerplateConfiguration {
    @Bean
    public MethodDigestLogInterceptor methodDigestLogInterceptor(){
        return new MethodDigestLogInterceptor();
    }
}