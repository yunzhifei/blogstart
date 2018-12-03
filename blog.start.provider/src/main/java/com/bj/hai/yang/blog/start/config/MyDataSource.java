package com.bj.hai.yang.blog.start.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.bj.hai.yang.blog.start.dao.user", sqlSessionFactoryRef = "masterSqlSessionFactory")
@PropertySource(value = "classpath:application-config.yml")
public class MyDataSource {

    @Value("${dataSource.url}")
    private String url;

    @Value("${dataSource.password}")
    private String password;

    @Value("${dataSource.userName}")
    private String userName;

    @Bean(name = "masterDataSource")
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


    @Bean(name = "masterTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean("masterSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier(value = "masterDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
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
