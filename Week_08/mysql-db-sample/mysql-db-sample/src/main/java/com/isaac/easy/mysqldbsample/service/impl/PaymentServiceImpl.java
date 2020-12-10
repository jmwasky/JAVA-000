package com.isaac.easy.mysqldbsample.service.impl;

import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallOrderMapper;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.service.IAccountService;
import com.isaac.easy.mysqldbsample.service.IOrderService;
import com.isaac.easy.mysqldbsample.service.IPaymentService;
import com.isaac.easy.mysqldbsample.service.IProductService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Resource
    private IOrderService orderService;
    @Resource
    private IAccountService accountService;
    @Resource
    private IProductService productService;

    @Resource
    private MallOrderMapper mallOrderMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    public boolean payOrder( MallOrder order ) {
        // 新建订单
        order.setStatus(2);
        mallOrderMapper.updateByPrimaryKey(order);

        // 冻结用户金额
        accountService.tryAccountPayment(order);
        // 冻结库存
        productService.tryProductFreeze(order);
        return true;
    }
    public boolean confirmOrder(final MallOrder order) {
        LOGGER.info("============执行order confirm 接口===============");
        return mallOrderMapper.confirm(order) > 0;
    }
    public boolean cancelOrder(final MallOrder order) {
        LOGGER.info("============执行order cancel 接口===============");
        return mallOrderMapper.cancel(order) > 0;
    }
    @Override
    public boolean payOrderWithException( Integer count, BigDecimal amount ) {
        return false;
    }

}
