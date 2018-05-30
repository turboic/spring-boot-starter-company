package com.zhxl.spring.boot.starter.company.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 实现类实现接口
 */
public class CompanyOperationImpl implements CompanyOperation {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyOperationImpl.class);
    private Company company;

    public CompanyOperationImpl(Company company) {
        Assert.notNull(company, " a valid company is required");
        this.company = company;
    }
    public CompanyOperationImpl(Config config) {
        Assert.notNull(config, " a valid config is required");
        Company company = new Company();
        company.setName(config.getName());
        company.setAddress(config.getName());
        this.company = company;
    }
    @Override
    public <T> T product(Config config,CompanyCallBack<T> action) throws OperationException {
        return action.doInBussiness(config);
    }

    @Override
    public Company product() throws OperationException {
        if (this.company.getName().equals("tj")){
            throw new OperationException("company name is valid");
        }
        return this.company;
    }
}
