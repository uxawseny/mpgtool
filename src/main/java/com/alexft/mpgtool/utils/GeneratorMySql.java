package com.alexft.mpgtool.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://zhuanlan.zhihu.com/p/272594727
 */
public class GeneratorMySql {
    //TODO 1.当前包名
    static String packageName = "com.hzst.synctool";
    //TODO 2.数据库类型
    static DbType dbType = DbType.MYSQL;
    //TODO 3.数据库连接地址
    static String dbUrl = "jdbc:mysql://localhost:3307/cloudalibaba?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true&allowMultiQueries=true";
    //TODO 4.驱动名
    static String driverName = "com.mysql.cj.jdbc.Driver";
    //TODO 5.数据库名
    static String dbName = "cloudalibaba";
    //TODO 6.数据库用户
    static String userName = "root";
    //TODO 7.数据库密码
    static String password = "12306";
    //TODO 8.表前缀
    static String tablePrefix = "com.mysql.cj.jdbc.Driver";
    //TODO 9.作者
    static String author = "author";
    //TODO 10.驼峰转连字符
    static boolean MappingHyphenStyle = true;
    //TODO 11.是否生成Swagger注解
    static boolean swagger = false;
    //TODO 12.时间类型对应策略
    static DateType dateType = DateType.ONLY_DATE;
    //TODO 13.Mapper名称格式(可以默认不配置)
    static String mapperName = "%sMapper";


    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        //1.开发者名字
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setKotlin(false);
        //是否覆盖已有文件
        gc.setFileOverride(true);
        //二级缓存。默认false
        gc.setEnableCache(false);
        //TODO 时间类型对应策略
        gc.setDateType(dateType);
        gc.setMapperName(mapperName);
        //Swagger2 实体属性 Swagger2 注解
        gc.setSwagger2(swagger);
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //2.数据库连接信息
        dsc.setUrl(dbUrl);
        //3.数据库名称
        dsc.setSchemaName(dbName);
        //4.数据库类型
        dsc.setDbType(dbType);
        dsc.setDriverName(driverName);
        //5.数据库用户名
        dsc.setUsername(userName);
        //6.数据库密码
        dsc.setPassword(password);
        mpg.setDataSource(dsc);
        //包配置
        PackageConfig pc = new PackageConfig();
        //7.生成代码的包名
        pc.setParent(packageName);
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名,如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper"
                        //         +  + pc.getModuleName() + 如果放开上面的模块名，这里就有一个模块名了
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的明明策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自定义继承的Entity类全称，带包名
        //strategy.setSuperEntityClass("***");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //自定义继承的Controller类全称，带包名
        //strategy.setSuperControllerClass("***");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //自定义基础的Entity类，公共字段（可添加更多）
        //strategy.setSuperEntityColumns("id");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(MappingHyphenStyle);
        //8.表前缀
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    //输入
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            return ipt;
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
