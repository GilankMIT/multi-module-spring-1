/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.core.model.holder;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: MethodDigestContextHolder.java, v 0.1 2023‐09‐29 17.43 gilang.prambudi Exp $$
 */
public class MethodDigestContextHolder {
   private static final ThreadLocal<MethodDigestContext> threadLocal = new ThreadLocal<>();

   private static void initNewContext(){
      MethodDigestContext methodDigestContext = new MethodDigestContext();
      threadLocal.set(methodDigestContext);
   }

   private static MethodDigestContext getLocalThread(){
      if(threadLocal.get() == null){
         initNewContext();
      }

      return threadLocal.get();
   }

   public static void setParam(String param){
      getLocalThread().setParam(param);
   }

   public static String getParam(){
      return getLocalThread().getParam();
   }

   public static void setResult(String result){
      getLocalThread().setResult(result);
   }

   public static String getResult(){
      return getLocalThread().getResult();
   }

   public static void setAdditionalInfo(String additionalInfo){
      getLocalThread().setAdditionalInfo(additionalInfo);
   }

   public static String getAdditionalInfo(){
      return getLocalThread().getAdditionalInfo();
   }
}