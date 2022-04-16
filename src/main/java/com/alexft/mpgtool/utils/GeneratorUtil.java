package com.alexft.mpgtool.utils;

import com.alexft.mpgtool.entity.DBParam;
import com.alexft.mpgtool.enums.DesPathEnum;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/272594727
 */
@Slf4j
public class GeneratorUtil {

    public static void Generator(DBParam dbParams) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        //TODO 代码生成根路径
        String projectPath;
        if (DesPathEnum.ABS_PATH.getMsg().equalsIgnoreCase(dbParams.getProjectPath())) {
            projectPath = DesPathEnum.ABS_PATH.getCode();
        } else {
            projectPath = System.getProperty("user.dir");
        }
        gc.setOutputDir(projectPath + "/src/main/java");
        //1.开发者名字
        gc.setAuthor(dbParams.getAuthor());
        gc.setOpen(false);
        gc.setKotlin(false);
        //是否覆盖已有文件
        gc.setFileOverride(true);
        //二级缓存。默认false
        gc.setEnableCache(false);
        //TODO 时间类型对应策略
        gc.setDateType(dbParams.getDateType());
        gc.setMapperName(dbParams.getMapperName());
        //Swagger2 实体属性 Swagger2 注解
        gc.setSwagger2(dbParams.isSwagger2());
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //2.数据库连接信息
        dsc.setUrl(dbParams.getDbUrl());
        //3.数据库名称
        dsc.setSchemaName(dbParams.getDbName());
        //4.数据库类型
        dsc.setDbType(dbParams.getDbType());
        dsc.setDriverName(dbParams.getDriverName());
        //5.数据库用户名
        dsc.setUsername(dbParams.getUserName());
        //6.数据库密码
        dsc.setPassword(dbParams.getPassword());
        mpg.setDataSource(dsc);
        //包配置
        PackageConfig pc = new PackageConfig();
        //7.生成代码的包名
        pc.setParent(dbParams.getPackageName());
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
        //TODO
        //strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setInclude(dbParams.getTableName());
        //自定义基础的Entity类，公共字段（可添加更多）
        //strategy.setSuperEntityColumns("id");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(dbParams.isMappingHyphenStyle());
        //8.表前缀
        strategy.setTablePrefix(dbParams.getTablePrefix());
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }


}
