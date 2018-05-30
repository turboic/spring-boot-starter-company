package com.zhxl.spring.boot.starter.company.rest;

public interface CompanyOperation {
    /**
     * 接口，生产实体内容
     * @param config
     * @return
     */
   <T> T product(Config config,CompanyCallBack<T> action);
   <T> T product();
}