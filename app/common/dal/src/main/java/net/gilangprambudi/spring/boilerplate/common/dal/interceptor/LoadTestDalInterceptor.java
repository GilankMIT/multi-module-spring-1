/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.dal.interceptor;

import net.gilangprambudi.spring.boilerplate.common.util.helper.SqlSourceBoundSql;
import net.gilangprambudi.spring.boilerplate.core.model.holder.LoadTestContextHolder;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Properties;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: LoadTestInterceptor.java, v 0.1 2023‐09‐29 08.11 gilang.prambudi Exp $$
 */

@Intercepts({
        @Signature(type = Executor.class, method = "update",
                args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
})
public class LoadTestDalInterceptor implements Interceptor {

   public ArrayList<String> TABLE_NAMES;

   private static final Logger LOGGER = LoggerFactory.getLogger(LoadTestDalInterceptor.class);

   @Override
   public Object intercept(Invocation invocation) throws Throwable {
      MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

      String originalSql = mappedStatement.getBoundSql(invocation.getArgs()[1]).getSql();
      String finalSql = originalSql;

      if(LoadTestContextHolder.isLoadTest()){
         LOGGER.info("load test is active, using shadow table");
         String modifiedSql = modifySql(originalSql);
         finalSql = modifiedSql;
         BoundSql boundSql = new BoundSql(
                 mappedStatement.getConfiguration(),
                 modifiedSql,
                 mappedStatement.getBoundSql(invocation.getArgs()[1]).getParameterMappings(),
                 invocation.getArgs()[1]
         );

         // Update the SQL query in the MappedStatement
         MappedStatement newMappedStatement = copyMappedStatement(mappedStatement, boundSql);
         invocation.getArgs()[0] = newMappedStatement;
      }

      LOGGER.info("sql statement {}", finalSql);
      return invocation.proceed();
   }

   public String modifySql(String originalSql){
      String[] words = originalSql.split("\\s+");
      StringBuilder result = new StringBuilder();

      for (String word : words) {
         String modifiedWord = word;

         for (String tableName : TABLE_NAMES) {
            if (word.equalsIgnoreCase(tableName)) {
               modifiedWord = word + "_t";
               break;
            }
         }

         result.append(modifiedWord).append(" ");
      }

      return result.toString().trim();
   }

   private MappedStatement copyMappedStatement(MappedStatement ms, BoundSql boundSql) {
      SqlSourceBoundSql sqlSourceBoundSql = new SqlSourceBoundSql(boundSql);
      MappedStatement.Builder builder = new MappedStatement.Builder(
              ms.getConfiguration(),
              ms.getId(),
              sqlSourceBoundSql,
              ms.getSqlCommandType()
      );

      builder.resource(ms.getResource());
      builder.parameterMap(ms.getParameterMap());
      builder.resultMaps(ms.getResultMaps());
      builder.cache(ms.getCache());

      return builder.build();
   }

   @Override
   public Object plugin(Object target) {
      return Plugin.wrap(target, this);
   }

   @Override
   public void setProperties(Properties properties) {

   }
}