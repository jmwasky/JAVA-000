package com.easy.hmily.provider.impl;

import com.easy.hmily.api.IPaymentService;
import com.easy.hmily.entity.Order;
import com.easy.hmily.entity.PaymentVo;
import com.easy.hmily.entity.FxAccount;
import com.easy.hmily.mapper.FxAccountMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author think
 * @date 2020/12/23
 */
@DubboService(version = "1.0.0", weight = 100)
public class PaymentService implements IPaymentService {

    private Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Resource
    private FxAccountMapper fxAccountMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @HmilyTCC(confirmMethod = "confirmPayment", cancelMethod = "cancelPayment")
    public Order payment( PaymentVo paymentVo ) {
        logger.debug("payment try>>>>>>>>>>>>>>>");
        FxAccount fxAccount = fxAccountMapper.selectFxAccountById(1L);

        logger.debug("payment query : {}", fxAccount);
        return null;
    }

    public Boolean confirmPayment (PaymentVo paymentVo) {
        logger.debug("payment confirm>>>>>>>>>>>>>>>");
        return true;
    }
    public Boolean cancelPayment (PaymentVo paymentVo) {
        logger.debug("payment cancel>>>>>>>>>>>>>>>");
        return true;
    }

}
