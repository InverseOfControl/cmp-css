package com.ipaylinks.cmp.css.test;

import com.alibaba.dubbo.common.json.JSON;
import com.ipaylinks.cmp.css.CmpCssApplication;
import com.ipaylinks.cmp.css.facade.QueryMerchantFeeFacade;
import com.ipaylinks.cmp.css.facade.QuerySettlementDetailFacade;
import com.ipaylinks.cmp.css.facade.QuerySettlementOrderFacade;
import com.ipaylinks.cmp.css.facade.QuerySettlementSummaryFacade;
import com.ipaylinks.cmp.css.facade.request.QueryMerchantFeeRequest;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementDetailRequest;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementRequest;
import com.ipaylinks.cmp.css.facade.request.QuerySettlementSummaryRequest;
import com.ipaylinks.common.page.PageBean;
import com.ipaylinks.common.rpc.BaseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmpCssApplication.class)
public class SettlementOrderFacadeTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private QuerySettlementDetailFacade querySettlementDetailFacade;
    @Autowired
    private QuerySettlementOrderFacade querySettlementFacade;
    @Autowired
    private QuerySettlementSummaryFacade querySettlementSummaryFacade;
    @Autowired
    private QueryMerchantFeeFacade queryMerchantFeeFacade;

    /**
     * 商户结算明细查询
     *
     * @author hongxu.gao
     * @date 2018/8/15 11:15
     */
    @Test
    public void querySettlementDetailTest() throws Exception{
        QuerySettlementDetailRequest request = new QuerySettlementDetailRequest();

        PageBean pageBean = new PageBean();
        pageBean.setPageNumber(1);
        pageBean.setPageSize(2);

        request.setPageBean(pageBean);
        request.setBeginSettleDate("20180624");
        request.setEndSettleDate("20180628");
        BaseResponse response = querySettlementDetailFacade.querySettlementDetail(request);
        System.err.println(JSON.json(response).toString());
    }

    /**
     * 商户结算单查询
     *   
     * @author hongxu.gao
     * @date 2018/8/15 11:15
     */
    @Test
    public void querySettlementInfoTest() throws Exception{
        QuerySettlementRequest request = new QuerySettlementRequest();

        PageBean pageBean = new PageBean();
        pageBean.setPageNumber(1);
        pageBean.setPageSize(2);

        request.setPageBean(pageBean);
        request.setOrderBeginDate("20180625");
        request.setOrderEndDate("20180629");
        BaseResponse response = querySettlementFacade.querySettlementOrder(request);
        System.err.println(JSON.json(response).toString());
    }

    /**
     * 商户结算汇总单查询
     *
     * @author hongxu.gao
     * @date 2018/8/15 11:14
     */
    @Test
    public void querySettlementSummaryTest() throws Exception{
        QuerySettlementSummaryRequest request = new QuerySettlementSummaryRequest();

        PageBean pageBean = new PageBean();
        pageBean.setPageNumber(1);
        pageBean.setPageSize(2);

        request.setPageBean(pageBean);
        request.setBeginDate("20180624");
        request.setEndDate("20180629");
        BaseResponse response = querySettlementSummaryFacade.querySettlementSummary(request);
        System.err.println(JSON.json(response).toString());
    }

    /**
     * 测试商户手续费查询接口
     *
     * @author hongxu.gao
     * @date 2018/8/15 11:10
     */
    @Test
    public void queryMerchantFeeTest() throws Exception{
        QueryMerchantFeeRequest request = new QueryMerchantFeeRequest();

        PageBean pageBean = new PageBean();
        pageBean.setPageNumber(1);
        pageBean.setPageSize(2);

        request.setPageBean(pageBean);
        BaseResponse response = queryMerchantFeeFacade.queryMerchantFee(request);
        System.err.println(JSON.json(response).toString());
    }

}
