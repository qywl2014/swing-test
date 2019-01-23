package com.wulang.utils;

import com.wulang.domain.MybatisGeneratorConfig;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorUtil {

    public static String generate(MybatisGeneratorConfig mybatisGeneratorConfig) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();

//        config.addClasspathEntry("D:\\desktop\\idea\\mybatis-test\\mybatis-generator-test\\src\\main\\resources\\postgresql-9.4.1209.jar");
        Context context = new Context(ModelType.CONDITIONAL);

        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
        commentGeneratorConfiguration.addProperty("suppressDate", "true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        String url = "jdbc:postgresql://" + mybatisGeneratorConfig.getHost() + ":" + mybatisGeneratorConfig.getPort() + "/" + mybatisGeneratorConfig.getDatabaseName();
        jdbcConnectionConfiguration.setDriverClass("org.postgresql.Driver");
        jdbcConnectionConfiguration.setConnectionURL(url);
        jdbcConnectionConfiguration.setUserId(mybatisGeneratorConfig.getUserName());
        jdbcConnectionConfiguration.setPassword(mybatisGeneratorConfig.getPassword());
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        String targetProjectPath = "D:\\desktop\\idea\\mybatis-test\\mybatis-generator-test";
        String sourcePath = targetProjectPath + "\\src\\main\\java";
        String resourcePath = targetProjectPath + "\\src\\main\\resources";

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        javaClientGeneratorConfiguration.setTargetPackage(mybatisGeneratorConfig.getMapperPackage());
        javaClientGeneratorConfiguration.setTargetProject(sourcePath);
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(mybatisGeneratorConfig.getModelPackage());
        javaModelGeneratorConfiguration.setTargetProject(sourcePath);
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage(mybatisGeneratorConfig.getXmlPackage());
        sqlMapGeneratorConfiguration.setTargetProject(resourcePath);
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        String schema = mybatisGeneratorConfig.getSchema();
        if (isValid(schema)) {
            tableConfiguration.setSchema(schema);
        }
        tableConfiguration.setTableName(mybatisGeneratorConfig.getTable());
        String domainObjectName = mybatisGeneratorConfig.getDomainObjectName();
        if (isValid(domainObjectName)) {
            tableConfiguration.setDomainObjectName(domainObjectName);
        }
        String mapperName = mybatisGeneratorConfig.getMapperName();
        if (isValid(mapperName)) {
            tableConfiguration.setMapperName(mapperName);
        }

        context.setId("pg");
        context.setTargetRuntime("MyBatis3");
        context.addTableConfiguration(tableConfiguration);
        config.addContext(context);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
            return "失败\n" + e.getMessage();
        }
        String warningStr = "警告\n";
        if (!warnings.isEmpty()) {
            for (String str : warnings) {
                warningStr = warningStr + str;
            }
            return warningStr;
        }
        return "成功\n";
    }

    public static boolean isValid(String str) {
        return str != null && !str.isEmpty();
    }

    public static void generate() {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();

//        config.addClasspathEntry("D:\\desktop\\idea\\mybatis-test\\mybatis-generator-test\\src\\main\\resources\\postgresql-9.4.1209.jar");
        Context context = new Context(ModelType.CONDITIONAL);

        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
        commentGeneratorConfiguration.addProperty("suppressDate", "true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass("org.postgresql.Driver");
        jdbcConnectionConfiguration.setConnectionURL("jdbc:postgresql://127.0.0.1:5432/kkcx");
        jdbcConnectionConfiguration.setUserId("postgres");
        jdbcConnectionConfiguration.setPassword("123456");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage("com.wulang.localdatabase.model");
        javaModelGeneratorConfiguration.setTargetProject("D:\\desktop\\idea\\mybatis-test\\mybatis-generator-test\\src\\main\\java");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage("sqlmap");
        sqlMapGeneratorConfiguration.setTargetProject("D:\\desktop\\idea\\mybatis-test\\mybatis-generator-test\\src\\main\\resources");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        javaClientGeneratorConfiguration.setTargetPackage("com.wulang.localdatabase.dao");
        javaClientGeneratorConfiguration.setTargetProject("D:\\desktop\\idea\\mybatis-test\\mybatis-generator-test\\src\\main\\java");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setSchema("kkcx");
        tableConfiguration.setTableName("hist_signed_talent_apply");
        tableConfiguration.setDomainObjectName("HistSignedTalentApplyDO");
        tableConfiguration.setMapperName("HistSignedTalentApplyMapper");

        context.setId("pg");
        context.setTargetRuntime("MyBatis3");
        context.addTableConfiguration(tableConfiguration);
        config.addContext(context);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String str : warnings) {
            System.out.print(str);
        }
    }
}
