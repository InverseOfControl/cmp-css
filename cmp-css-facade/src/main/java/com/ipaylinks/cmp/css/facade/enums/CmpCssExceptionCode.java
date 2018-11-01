package com.ipaylinks.cmp.css.facade.enums;

public enum CmpCssExceptionCode {
    VIOLATION_UNIQUE_CONSTRAINT("10300002","违反唯一约束条件"),
    DATA_ALREADY_EXISTS("10300003","数据已存在"),
    DATA_NOT_EXISTS("10300004","数据不存在"),
    INVOKE_SERVICE_EXCEPTION("10300005","调用第三方服务异常"),
    CONCURRENT_EXCEPTION("10300006","并发异常"),
    DATABASE_EXCEPTION("10399996","数据库异常"),
    BUSINESS_ERROR("10399997","内部逻辑错误"),
    PARAMETERS_ERROR("10399998","参数错误"),
    SYSTEM_EXCEPTION("10399999","系统异常")

    ;

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    CmpCssExceptionCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CmpCssExceptionCode{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
