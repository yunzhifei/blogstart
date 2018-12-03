package com.bj.hai.yang.blog.start.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.bj.hai.yang.blog.start.dao.test", sqlSessionFactoryRef = "testSqlSessionFactory")
@PropertySource(value = "classpath:application-config.yml")
public class MyTestDataSource {

    @Value("${dataSource1.url}")
    private String url;

    @Value("${dataSource1.password}")
    private String password;

    @Value("${dataSource1.userName}")
    private String userName;

    @Bean(name = "dataSourceTest")
    @Primary
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


    @Bean(name = "testTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("dataSourceTest") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean("testSqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier(value = "dataSourceTest") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config2.xml"));
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory.getObject();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
