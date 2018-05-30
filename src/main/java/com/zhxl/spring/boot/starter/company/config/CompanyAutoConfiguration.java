package com.zhxl.spring.boot.starter.company.config;


import com.zhxl.spring.boot.starter.company.rest.CompanyOperationImpl;
import com.zhxl.spring.boot.starter.company.rest.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//初始化Bean主机
@EnableConfigurationProperties(value=CompanyProperties.class)//开始properties属性注入
@ConditionalOnClass(value = CompanyOperationImpl.class)//需要加载类
public class CompanyAutoConfiguration {
    @Autowired
    private CompanyProperties companyProperties;
    @Bean
    @ConditionalOnMissingBean(CompanyOperationImpl.class)
    public CompanyOperationImpl companyOperation(){
        Config config = new Config();
        config.setAddress(companyProperties.getAddress());
        config.setName(companyProperties.getName());
        return new CompanyOperationImpl(config);
    }
}
