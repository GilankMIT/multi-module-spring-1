/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.core.service.repository.impl;

import net.gilangprambudi.spring.boilerplate.common.dal.dao.SpringBoilerplateUserDAO;
import net.gilangprambudi.spring.boilerplate.common.dal.dataobject.UserDO;
import net.gilangprambudi.spring.boilerplate.core.service.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: UserRepositoryImpl.java, v 0.1 2023‐09‐28 00.47 gilang.prambudi Exp $$
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

   @Autowired
   private SpringBoilerplateUserDAO springBoilerplateUserDAO;

   @Override
   public List<UserDO> getAllUser() {
      return springBoilerplateUserDAO.getAll();
   }

   @Override
   public void insert(UserDO userDO) {
      springBoilerplateUserDAO.insert(userDO);
   }
}