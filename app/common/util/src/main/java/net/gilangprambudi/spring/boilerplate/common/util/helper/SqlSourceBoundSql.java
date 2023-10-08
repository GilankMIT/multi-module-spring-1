/**
 * gilangprambudi.net
 * Copyright (c) 2019‐2023 All Rights Reserved.
 */
package net.gilangprambudi.spring.boilerplate.common.util.helper;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author gilang.prambudi (gilang.prambudi@dana.id)
 * @version $Id: SqlSourceBoundSql.java, v 0.1 2023‐09‐29 11.24 gilang.prambudi Exp $$
 */
public class SqlSourceBoundSql implements SqlSource {

    BoundSql boundSql;

    public SqlSourceBoundSql(BoundSql boundSql){
        this.boundSql = boundSql;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return this.boundSql;
    }
}