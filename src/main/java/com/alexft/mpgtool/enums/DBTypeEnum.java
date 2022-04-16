package com.alexft.mpgtool.enums;

/**
 * 数据库类型
 */
public enum DBTypeEnum {

    MYSQL("MYSQL", "MYSQL"),
    DM("DM", "DM"),
    ORACLE("ORACLE", "ORACLE"),
    ;

    private String code;
    private String msg;

    DBTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
