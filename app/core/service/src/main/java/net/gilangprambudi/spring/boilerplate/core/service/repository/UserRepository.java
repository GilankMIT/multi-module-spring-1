/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.core.service.repository;

import net.gilangprambudi.spring.boilerplate.common.dal.dataobject.UserDO;

import java.util.List;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: repository.java, v 0.1 2023‐09‐28 00.45 gilang.prambudi Exp $$
 */
public interface UserRepository {
    List<UserDO> getAllUser();
    void insert(UserDO userDO);
}