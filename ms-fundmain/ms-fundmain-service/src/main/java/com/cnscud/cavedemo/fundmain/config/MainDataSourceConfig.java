package com.cnscud.cavedemo.fundmain.config;


import com.cnscud.xpower.dbn.SimpleDBNDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Database Config 多数据源配置: 主数据源.
 * 数据源动态从Zookeeper创建/更新.
 *
 * @author Felix Zhang 2021-08-02 17:30
 * @version 1.0.0
 */
@Configuration
@MapperScan(basePackages = {"com.cnscud.cavedemo.fundmain.dao"},
        sqlSessionFactoryRef = "sqlSessionFactoryMainDataSource")
public class MainDataSourceConfig {

    /**
     * 添加@Primary注解，设置默认数据源，事务管理器.
     * 此处使用了一个可以动态重建的DataSource, 如果Zookeeper配置改变,会动态重建.
     */
    @Primary
    @Bean(name = "mainDataSource")
    public DataSource mainDataSource() throws Exception {
        return SimpleDBNDataSourceFactory.getInstance().getDataSource("cavedemo");
    }


    /*
    //常规配置: 使用application.yml里面的配置.
    @Primary
    @Bean(name = "mainDataSource")
    @ConfigurationProperties("spring.datasource.main")
    public DataSource mainDataSource() throws Exception {
        return DataSourceBuilder.create().build();
    }
    */

    @Primary
    @Bean(name = "sqlSessionFactoryMainDataSource")
    public SqlSessionFactory sqlSessionFactoryMainDataSource(@Qualifier("mainDataSource") DataSource mainDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //configuration.setMapUnderscoreToCamelCase(true);
        //factoryBean.setConfiguration(configuration);
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));

        // 使用mainDataSource数据源, 连接mainDataSource库
        factoryBean.setDataSource(mainDataSource);

        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        //指定entity和mapper xml的路径
        //factoryBean.setTypeAliasesPackage("com.cnscud.cavedemo.fundmain.model");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/cnscud/cavedemo/fundmain/mapper/*.xml"));
        return factoryBean.getObject();
    }

    @Primary
    @Bean
    public SqlSessionTemplate sqlSessionTemplateMainDataSource(@Qualifier("sqlSessionFactoryMainDataSource") SqlSessionFactory sqlSessionTemplateMainDataSource) throws Exception {

        //使用注解中配置的Factory
        return new SqlSessionTemplate(sqlSessionTemplateMainDataSource);
    }

    @Primary
    @Bean
    public PlatformTransactionManager mainTransactionManager(@Qualifier("mainDataSource") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }
}
