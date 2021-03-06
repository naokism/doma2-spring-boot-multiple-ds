package com.example;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("config1")
public class ConfigDS1 implements Config{

    private DataSource dataSource;

    private Dialect dialect;

    @Autowired
    @Qualifier("ds1")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = new TransactionAwareDataSourceProxy(dataSource);
    }


    @Override
    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Autowired
    public void setDialect(@Value("${doma.ds1.dialect}") String domaDialect)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.dialect = (Dialect) Class.forName(domaDialect).newInstance();
    }

    @Override
    public Dialect getDialect() {
        return this.dialect;
    }
}
