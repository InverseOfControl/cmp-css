package com.ipaylinks.cmp.css.facade.enums;

/**
 * 收费方式
 */
public enum ChargeMethodEnum {

	INNER("01", "内收"),
	OUTER("02", "外收");

    private String code;
    private String desc;

    private ChargeMethodEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDescByCode(String code){
        for (ChargeMethodEnum temp : ChargeMethodEnum.values()){
            if(temp.getCode().equals(code)){
                return temp.getDesc();
            }
        }
        return null;
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
