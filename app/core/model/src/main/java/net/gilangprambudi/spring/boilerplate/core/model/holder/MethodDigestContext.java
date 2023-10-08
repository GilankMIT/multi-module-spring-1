/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.core.model.holder;

import lombok.Data;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: MethodDigestContext.java, v 0.1 2023‐09‐29 17.42 gilang.prambudi Exp $$
 */
@Data
public class MethodDigestContext {
   private String param;
   private String result;
   private String additionalInfo;
}