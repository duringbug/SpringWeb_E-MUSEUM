package com.tjf.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tjf.spring.config.webSocket.WebSocketConfig;
import org.jetbrains.annotations.NotNull;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.text.SimpleDateFormat;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:30
 * @description:
 */
@Configuration
@EnableWebSocket
@ComponentScan({ "com.tjf.myBatis.*", "com.tjf.utils" })
@PropertySource({ "classpath:jdbc.properties" })
@ImportResource(locations = { "classpath:springConfig.xml" })
@Import(WebSocketConfig.class)
public class SpringConfig {
    @Value("${local.driver}")
    private String jdbcDriver;
    @Value("${local.url}")
    private String jdbcUrl;
    @Value("${local.username}")
    private String jdbcUsername;
    @Value("${local.password}")
    private String jdbcPassword;

    @Bean(name = "druidDataSourceClass")
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactoryBeanClass")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(
            @Qualifier("druidDataSourceClass") DruidDataSource druidDataSource,
            @Value("classpath:com/tjf/myBatis/mapper/*.xml") Resource[] resources) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com/tjf/myBatis/project");
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean;
    }

    @Bean(name = "sqlSessionTemplateClass")
    public SqlSessionTemplate getSqlSessionTemplate(
            @Qualifier("sqlSessionFactoryBeanClass") @NotNull SqlSessionFactoryBean sqlSessionFactoryBean)
            throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
        return sqlSessionTemplate;
    }

    @Bean(name = "modeAndView")
    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    @Bean(name = "objectMapperController")
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
    /**
     * WebSocket
     */

}
