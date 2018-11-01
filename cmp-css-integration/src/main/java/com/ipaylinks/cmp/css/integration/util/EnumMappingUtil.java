package com.ipaylinks.cmp.css.integration.util;

import com.ipaylinks.ccs.facade.enums.ChargeSceneEnum;
import com.ipaylinks.cmp.css.facade.enums.CmpCssExceptionCode;
import com.ipaylinks.cmp.css.facade.enums.PayTypeEnum;
import com.ipaylinks.common.CardOrgEnum;
import com.ipaylinks.common.enums.TradeTypeEnum;
import com.ipaylinks.cmp.css.util.BusinessException;
import org.apache.commons.lang3.StringUtils;

/**
 * 枚举类型映射
 * @author ipay
 * @date 2018/8/14 14:11  
 */
public final class EnumMappingUtil {

   public static ChargeSceneEnum tradeTypeEnum2ChargeSceneEnum(TradeTypeEnum tradeTypeEnum) throws Exception {
       ChargeSceneEnum chargeSceneEnum = null;
       switch (tradeTypeEnum) {
           case SALE:
               chargeSceneEnum = ChargeSceneEnum.Pay;
               break;
           case CAPTURE:
               chargeSceneEnum = ChargeSceneEnum.Pay;
               break;
           case REFUND:
               chargeSceneEnum = ChargeSceneEnum.Refund;
               break;
           case CHARGEBACK:
               chargeSceneEnum = ChargeSceneEnum.Protest;
               break;
           case VOID:
               chargeSceneEnum = ChargeSceneEnum.Refund;
               break;
           default:
               throw new BusinessException(CmpCssExceptionCode.PARAMETERS_ERROR.getCode(), "未知的订单类型");
       }
       return chargeSceneEnum;
   }

    /**
     *
     * @param payKind
     * @return 支付方式 01-信用卡支付 02-本地化支付
     */
   public static String getPayMethodByPayKind(String payKind){
        if(StringUtils.isBlank(payKind)){
            return PayTypeEnum.LocalizedPayment.getCode();
        }
        if(CardOrgEnum.VISA.getOrgName().equalsIgnoreCase(payKind)
            || CardOrgEnum.MASTER.getOrgName().equalsIgnoreCase(payKind)
            || CardOrgEnum.JCB.getOrgName().equalsIgnoreCase(payKind)
            || CardOrgEnum.AE.getOrgName().equalsIgnoreCase(payKind)
            || CardOrgEnum.DC.getOrgName().equalsIgnoreCase(payKind)){
            return PayTypeEnum.CardsAccepted.getCode();
        }
       return PayTypeEnum.LocalizedPayment.getCode();
   }

   public static String getCardOrgByPayKind(String payKind){
       String payMethod = getPayMethodByPayKind(payKind);
       if(PayTypeEnum.CardsAccepted.getCode().equals(payMethod)){
           return payKind;
       }
       return null;
   }

}
