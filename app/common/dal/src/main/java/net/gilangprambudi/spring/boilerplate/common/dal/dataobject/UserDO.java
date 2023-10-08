/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.dal.dataobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.gilangprambudi.spring.boilerplate.common.util.model.DataObject;

import java.io.Serializable;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: UserDO.java, v 0.1 2023‐09‐28 00.42 gilang.prambudi Exp $$
 */
@Getter
@Setter
@Builder
public class UserDO implements DataObject, Serializable {
   private String id;
   private String username;
   private String email;

   @Override
   public String toString(){
      try {
         ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.writeValueAsString(this);
      } catch (Exception e) {
         e.printStackTrace();
         return "{}"; // Handle the exception gracefully
      }
   }
}