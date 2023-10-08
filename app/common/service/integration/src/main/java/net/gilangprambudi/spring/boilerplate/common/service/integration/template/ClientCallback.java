/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.service.integration.template;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: ClientCallback.java, v 0.1 2023‐09‐29 18.00 gilang.prambudi Exp $$
 */
public interface ClientCallback {
   void execute() throws Throwable;
   void composeDigestLog();
   void composeExceptionDigestLog(Throwable e);
}