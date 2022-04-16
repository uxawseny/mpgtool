package com.alexft.mpgtool.enums;

/**
 * 文件生成目标路径
 */
public enum DesPathEnum {

    ABS_PATH("/Users/ux/Downloads", "ABS_PATH"),
    IDEA_PATH("user.dir", "IDEA_PATH"),
    ;

    private String code;
    private String msg;

    DesPathEnum(String code, String msg) {
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
