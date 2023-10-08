/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.service.integration.producthttp.impl;

import net.gilangprambudi.spring.boilerplate.common.service.integration.producthttp.ProductServiceHTTPClient;
import net.gilangprambudi.spring.boilerplate.common.service.integration.template.ClientCallback;
import net.gilangprambudi.spring.boilerplate.common.service.integration.template.ClientTemplate;
import net.gilangprambudi.spring.boilerplate.common.util.annotation.MethodDigestLog;
import net.gilangprambudi.spring.boilerplate.core.model.holder.MethodDigestContextHolder;
import net.gilangprambudi.spring.boilerplate.core.model.http.client.Product;
import net.gilangprambudi.spring.boilerplate.core.model.http.client.SubProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: ProductServiceHTTPClientImpl.java, v 0.1 2023‐09‐29 16.34 gilang.prambudi Exp $$
 */

@Service
public class ProductServiceHTTPClientImpl implements ProductServiceHTTPClient {

   private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceHTTPClientImpl.class);

   @Override
   @MethodDigestLog(logName = "DIGEST-INTEGRATION")
   public Product getProductById(long id) {
      Product productResult = Product.builder().build();

      ClientTemplate.execute(productResult, new ClientCallback(){

         @Override
         public void execute() throws Throwable{
            productResult.setId(1);
            productResult.setTitle("Hello hello bandung");
            productResult.setDescription("this is a description");
            productResult.setPrice(10);
            SubProduct subProduct = SubProduct.builder().name("subProduct 1").build();
            SubProduct subProduct2 = SubProduct.builder().name("subProduct 2").build();
            productResult.setSubProductList(Arrays.asList(subProduct, subProduct2));
            throw new Exception("test");
         }

         @Override
         public void composeDigestLog() {
            MethodDigestContextHolder.setParam(id+"");
            MethodDigestContextHolder.setResult(productResult.toString());
         }

         @Override
         public void composeExceptionDigestLog(Throwable e) {
            LOGGER.error(e.getMessage());
         }
      });

      return productResult;
   }
}