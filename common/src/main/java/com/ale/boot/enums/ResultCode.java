package com.ale.boot.enums;

public enum ResultCode {
    SUCCESS(0, "成功"),
    SYS_ERROR(500, "系统异常，请稍后重试"),
    USER_EXITS(20001, "用户已存在"),
    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    USER_NOT_EXITS(20002, "用户不存在");
    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
