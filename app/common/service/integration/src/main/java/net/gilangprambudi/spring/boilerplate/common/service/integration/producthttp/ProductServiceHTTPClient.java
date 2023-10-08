/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.service.integration.producthttp;

import net.gilangprambudi.spring.boilerplate.core.model.http.client.Product;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: ProductServiceHTTPClient.java, v 0.1 2023‐09‐29 16.30 gilang.prambudi Exp $$
 */
public interface ProductServiceHTTPClient {
    Product getProductById(long id);
}