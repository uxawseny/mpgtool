package com.alexft.mpgtool.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DBParam {
    private static final long serialVersionUID = 1L;

    //1.当前包名
    private String packageName;
    //2.数据库类型
    private DbType dbType;
    //3.数据库连接地址
    private String dbUrl;
    //4.驱动名
    private String driverName;
    //5.数据库名
    private String dbName;
    //6.数据库用户
    private String userName;
    //7.数据库密码
    private String password;
    //8.表前缀
    private String tablePrefix;
    //9.作者
    private String author;
    //10.驼峰转连字符
    private boolean mappingHyphenStyle = true;
    //11.是否生成Swagger注解
    private boolean swagger2 = false;
    //12.时间类型对应策略
    private DateType dateType;
    //13.Mapper名称格式(可以默认不配置)
    private String mapperName;

    //14.表名
    private String tableName;

    private String projectPath;
}
