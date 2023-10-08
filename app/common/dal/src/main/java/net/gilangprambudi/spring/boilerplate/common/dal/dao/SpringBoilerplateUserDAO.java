/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */

package net.gilangprambudi.spring.boilerplate.common.dal.dao;

import net.gilangprambudi.spring.boilerplate.common.util.model.DataObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: net.gilangprambudi.spring.boilerplate.common.dal.dao.SpringBoilerplateUserDAO.java, v 0.1 2023‐09‐28 00.34 gilang.prambudi Exp $$
 */

@Mapper
public interface SpringBoilerplateUserDAO<K extends DataObject>{
    List<K> getAll();
    void insert(K k);
}