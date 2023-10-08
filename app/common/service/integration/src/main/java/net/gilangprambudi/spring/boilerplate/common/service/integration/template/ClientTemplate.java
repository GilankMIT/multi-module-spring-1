/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.service.integration.template;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: ClientTemplate.java, v 0.1 2023‐09‐29 17.59 gilang.prambudi Exp $$
 */
public class ClientTemplate {
   public static void execute(Object result, ClientCallback clientCallback){
      try{
         clientCallback.execute();
      } catch (Throwable e){
         clientCallback.composeExceptionDigestLog(e);
      } finally{
         clientCallback.composeDigestLog();
      }
   }
}