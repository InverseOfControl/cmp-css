package com.ipaylinks.cmp.css.facade.enums;

/**
 * 清算状态
 */
public enum LiquidationStatusEnum {

	INIT("00", "未处理"),
	CLEARING_SUCCESS("01", "已生成清分明细"),
	CLEARING_FAILED("02", "生成清分明细失败"),
    SETTLEMENT_SUCCESS("03", "已生成结算明细"),
    SETTLEMENT_FAILED("04", "生成结算明细失败");

    private String code;
    private String desc;

    private LiquidationStatusEnum(String code, String desc) {
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
