package com.zhxl.spring.boot.starter.company.rest;
public interface CompanyCallBack<T> {
    T doInBussiness(Config config) throws OperationException;
}