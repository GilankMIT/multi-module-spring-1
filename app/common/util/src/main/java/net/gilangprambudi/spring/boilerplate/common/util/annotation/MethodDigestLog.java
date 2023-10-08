/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: MethodDigestLog.java, v 0.1 2023‐09‐29 16.38 gilang.prambudi Exp $$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodDigestLog {
   String logName();
}