package com.ipaylinks.cmp.css.facade.enums;

public enum DateEnum {

	 	day("01","日结"),
	 	month("02", "月结"),
	    DN("01", "D+N"),
	    TN("02", "T+N"); 

	    private String code;
	    private String desc;

	    private DateEnum(String code, String desc) {
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
