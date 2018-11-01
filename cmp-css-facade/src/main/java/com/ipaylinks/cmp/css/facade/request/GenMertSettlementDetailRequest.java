package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GenMertSettlementDetailRequest extends BaseRequest{

    private static final long serialVersionUID = -1L;

    /**
     * 订单ID：清算主订单ID、风控订单ID
     */
    @NotNull(message = "oriId不能为空")
    @NotEmpty(message = "oriId不能为空")
    private String oriId;

    public String getOriId() {
        return oriId;
    }

    public void setOriId(String oriId) {
        this.oriId = oriId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
