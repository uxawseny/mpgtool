package com.alexft.mpgtool.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MysqlParam {
    private static final long serialVersionUID = 1L;
    //1.当前包名
    private String packageName = "com.code.tool";
    //2.数据库类型
    private DbType dbType = DbType.MYSQL;
    //3.数据库连接地址
    private String dbUrl = "jdbc:mysql://localhost:3307/db1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true&allowMultiQueries=true";
    //4.驱动名
    private String driverName = "com.mysql.cj.jdbc.Driver";
    //5.数据库名
    private String dbName = "db1";
    //6.数据库用户
    private String userName = "root";
    //7.数据库密码
    private String password = "root";
    //8.表前缀
    private String tablePrefix = "";
    //9.作者
    private String author = "author";
    //10.驼峰转连字符
    private boolean mappingHyphenStyle = true;
    //11.是否生成Swagger注解
    private boolean swagger2 = false;
    //12.时间类型对应策略
    private DateType dateType = DateType.ONLY_DATE;
    //13.Mapper名称格式(可以默认不配置)
    private String mapperName = "%sMapper";

    //14.表名
    private String tableName;

    private String projectPath;
}
