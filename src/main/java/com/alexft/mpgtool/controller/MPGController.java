package com.alexft.mpgtool.controller;

import com.alexft.mpgtool.entity.*;
import com.alexft.mpgtool.enums.DBTypeEnum;
import com.alexft.mpgtool.utils.GeneratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码生成工具-web端
 */
@RestController
@RequestMapping("/mpg")
public class MPGController {


    @PostMapping("/generator")
    public String mpgtool(@RequestParam(value = "dbType", defaultValue = "mysql,oracle,dm") String dbType,
                          @RequestParam(value = "tableName") String tableName,
                          @RequestParam(value = "projectPath", defaultValue = "IDEA_PATH") String projectPath) {
        //MYSQL
        if (DBTypeEnum.MYSQL.getCode().equalsIgnoreCase(dbType)) {
            DBParam dbParams = new DBParam();
            MysqlParam mysql = new MysqlParam();
            mysql.setTableName(tableName);
            mysql.setProjectPath(projectPath);
            BeanUtils.copyProperties(mysql, dbParams);
            GeneratorUtil.Generator(dbParams);
        }
        //ORACLE
        else if (DBTypeEnum.ORACLE.getCode().equalsIgnoreCase(dbType)) {
            DBParam dbParams = new DBParam();
            OracleParam oracle = new OracleParam();
            oracle.setTableName(tableName);
            oracle.setProjectPath(projectPath);
            BeanUtils.copyProperties(oracle, dbParams);
            GeneratorUtil.Generator(dbParams);
        }
        //DM
        else if (DBTypeEnum.DM.getCode().equalsIgnoreCase(dbType)) {
            DBParam dbParams = new DBParam();
            DMParam dm = new DMParam();
            dm.setTableName(tableName);
            dm.setProjectPath(projectPath);
            BeanUtils.copyProperties(dm, dbParams);
            GeneratorUtil.Generator(dbParams);
        }

        return "执行成功!";
    }


}
