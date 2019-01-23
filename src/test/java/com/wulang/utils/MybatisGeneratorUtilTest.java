package com.wulang.utils;

import com.google.gson.Gson;
import com.wulang.domain.MybatisGeneratorConfig;
import org.junit.Test;

public class MybatisGeneratorUtilTest {
    @Test
    public void generateTest(){
        MybatisGeneratorConfig mybatisGeneratorConfig=new MybatisGeneratorConfig();
//        mybatisGeneratorConfig.setMapperPackage("com.wulang.dao");
//        mybatisGeneratorConfig.setModelPackage("com.wulang.model");
//        mybatisGeneratorConfig.setXmlPackage("com.sqlmap");

        mybatisGeneratorConfig.setTable("userinfo");
        mybatisGeneratorConfig.setSchema("kkcx");
//        mybatisGeneratorConfig.setMapperName();
//        mybatisGeneratorConfig.setDomainObjectName(domainObjectText.getText());

        mybatisGeneratorConfig.setHost("127.0.0.1");
        mybatisGeneratorConfig.setPort("5432");
        mybatisGeneratorConfig.setDatabaseName("kkcx");
        mybatisGeneratorConfig.setUserName("postgres");
        mybatisGeneratorConfig.setPassword("123456");

        System.out.println(new Gson().toJson(mybatisGeneratorConfig));
        System.out.println(new Gson().fromJson(new Gson().toJson(mybatisGeneratorConfig),MybatisGeneratorConfig.class));
//        MybatisGeneratorUtil.generate(mybatisGeneratorConfig);
    }
}
