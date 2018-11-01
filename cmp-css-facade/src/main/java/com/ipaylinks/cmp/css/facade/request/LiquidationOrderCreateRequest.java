package com.ipaylinks.cmp.css.facade.request;

import com.ipaylinks.cmp.css.facade.dto.LiquidationOrderDTO;
import com.ipaylinks.cmp.css.facade.dto.LiquidationSubOrderDTO;
import com.ipaylinks.common.rpc.BaseRequest;
import net.sf.oval.constraint.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class LiquidationOrderCreateRequest extends BaseRequest{

    private static final long serialVersionUID = -1L;

    /**
     * 清算主订单
     */
    @NotNull(message = "liquidationOrderDTO不能为空")
    private LiquidationOrderDTO liquidationOrderDTO;

    /**
     * 清算子订单
     */
    @NotNull(message = "liquidationSubOrderDTOList不能为空")
    private List<LiquidationSubOrderDTO> liquidationSubOrderDTOList;

    public LiquidationOrderDTO getLiquidationOrderDTO() {
        return liquidationOrderDTO;
    }

    public void setLiquidationOrderDTO(LiquidationOrderDTO liquidationOrderDTO) {
        this.liquidationOrderDTO = liquidationOrderDTO;
    }

    public List<LiquidationSubOrderDTO> getLiquidationSubOrderDTOList() {
        return liquidationSubOrderDTOList;
    }

    public void setLiquidationSubOrderDTOList(List<LiquidationSubOrderDTO> liquidationSubOrderDTOList) {
        this.liquidationSubOrderDTOList = liquidationSubOrderDTOList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
