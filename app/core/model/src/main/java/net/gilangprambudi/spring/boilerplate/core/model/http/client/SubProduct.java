/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.core.model.http.client;

import lombok.Builder;
import lombok.Data;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: SubProduct.java, v 0.1 2023‐10‐07 08.48 gilang.prambudi Exp $$
 */
@Data
@Builder
public class SubProduct {
   private int id;
   private String name;
}