/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.dal.config;

import net.gilangprambudi.spring.boilerplate.common.dal.interceptor.LoadTestDalInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: SpringBoilerplateDALConfig.java, v 0.1 2023‐09‐28 00.33 gilang.prambudi Exp $$
 */

@Configuration
@MapperScan("net.gilangprambudi.spring.boilerplate.common.dal.dao")
public class SpringBoilerplateDALConfig {
    @Bean
    public LoadTestDalInterceptor loadTestInterceptor(){
        LoadTestDalInterceptor loadTestDalInterceptor = new LoadTestDalInterceptor();
        loadTestDalInterceptor.TABLE_NAMES = new ArrayList<>();
        loadTestDalInterceptor.TABLE_NAMES.add("user");
        return loadTestDalInterceptor;
    }
}