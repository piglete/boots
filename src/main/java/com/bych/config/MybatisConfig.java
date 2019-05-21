//package com.bych.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages="com.bych")
//public class MybatisConfig {
//    @Autowired
//    private Environment env;
//    /**
//     * 创建数据源
//     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
//     */
////    @Bean
////    //@Primary
////    public DataSource getDataSource() throws Exception{
////        Properties props = new Properties();
////        props.put("driverClassName", env.getProperty("spring.datasource.driver-class-name"));
////        props.put("url", env.getProperty("spring.datasource.url"));
////        props.put("username", env.getProperty("spring.datasource.username"));
////        props.put("password", env.getProperty("spring.datasource.password"));
////        return DruidDataSourceFactory.createDataSource(props);
////    }
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource getDataSource() {
//        return new DruidDataSource();
//    }
//    @Bean
//    public PlatformTransactionManager txManager() throws Exception {
//        return new DataSourceTransactionManager(getDataSource());
//    }
//
//    /**
//     * 根据数据源创建SqlSessionFactory
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
//        fb.setObjectWrapperFactory(new MapWrapperFactory());
//        fb.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.basePackage"));//指定基包
//        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//指定xml文件位置
//
//        return fb.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//    @Bean
//    public ConfigurationCustomizer mybatisConfigurationCustomizer(){
//        return new ConfigurationCustomizer() {
//            @Override
//            public void customize(org.apache.ibatis.session.Configuration configuration) {
//                configuration.setObjectWrapperFactory(new MapWrapperFactory());
//            }
//        };
//    }
//
//}