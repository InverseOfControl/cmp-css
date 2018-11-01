package com.ipaylinks.cmp.css.facade.enums;

/**
 * 商户结算明细状态
 */
public enum MertClearingDetailStatusEnum {


	INIT("00", "未处理"),
	SUCCESS("01", "已生成结算明细"),
	FAILED ("02", "生成结算明细失败");

    private String code;
    private String desc;

    private MertClearingDetailStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getEnumName() {
        return this.getEnumName();
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
