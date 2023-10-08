/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.web.user.controller;

import net.gilangprambudi.spring.boilerplate.common.dal.dataobject.UserDO;
import net.gilangprambudi.spring.boilerplate.common.service.integration.producthttp.impl.ProductServiceHTTPClientImpl;
import net.gilangprambudi.spring.boilerplate.common.util.helper.StringHelper;
import net.gilangprambudi.spring.boilerplate.core.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: HelloController.java, v 0.1 2023‐09‐28 00.20 gilang.prambudi Exp $$
 */

@RestController
public class HelloController {

   @Autowired
   TransactionTemplate transactionTemplate;

   @Autowired
   UserRepository userRepository;

   @Autowired
   ProductServiceHTTPClientImpl productServiceHTTPClient;

   @GetMapping("/api/hello")
   public List<UserDO> helloWorld(){
      productServiceHTTPClient.getProductById(1);
      return userRepository.getAllUser();
   }

   @GetMapping("/api/insert-new-data")
   public String insertNewData(){
      transactionTemplate.execute(new TransactionCallbackWithoutResult() {
         @Override
         protected void doInTransactionWithoutResult(TransactionStatus status) {
            userRepository.insert(UserDO.
                    builder().
                    id(StringHelper.generateRandomString(10)).
                    username("test").
                    email(StringHelper.generateRandomString(5) + "@gilangprambudi.net").
                    build());
         }
      });

      return "Success";
   }
}