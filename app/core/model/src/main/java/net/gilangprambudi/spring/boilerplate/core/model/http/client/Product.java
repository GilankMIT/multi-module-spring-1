/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.core.model.http.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: Product.java, v 0.1 2023‐09‐29 16.31 gilang.prambudi Exp $$
 */
@Data
@Builder
public class Product{
   private long id;
   private String title;
   private String description;
   private long price;
   List<SubProduct> subProductList;

   @Override
   public String toString(){
      try {
         ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.writeValueAsString(this);
      } catch (Exception e) {
         e.printStackTrace();
         return "{}";
      }
   }
}