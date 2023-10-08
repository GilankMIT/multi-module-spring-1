/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.core.model.holder;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: LoadTestContextHolder.java, v 0.1 2023‐09‐29 11.51 gilang.prambudi Exp $$
 */
public class LoadTestContextHolder {
   private static final ThreadLocal<LoadTestContext> threadLocal = new ThreadLocal<>();

   public static void initNewContext(boolean isLoadTest){
      LoadTestContext loadTestContext = new LoadTestContext();
      loadTestContext.setLoadTest(isLoadTest);
      threadLocal.set(loadTestContext);
   }

   public static boolean isLoadTest(){
      if(threadLocal.get() == null){
         return false;
      }
      return threadLocal.get().isLoadTest();
   }
}