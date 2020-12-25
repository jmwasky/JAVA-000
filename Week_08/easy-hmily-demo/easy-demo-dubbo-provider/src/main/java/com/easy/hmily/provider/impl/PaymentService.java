package com.easy.hmily.provider.impl;

import com.easy.hmily.api.IPaymentService;
import com.easy.hmily.entity.Order;
import com.easy.hmily.entity.PaymentVo;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author think
 * @date 2020/12/23
 */
@DubboService(version = "1.0.0", weight = 100)
public class PaymentService implements IPaymentService {

    private Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Override
    @Transactional(rollbackFor = Exception.class)
    @HmilyTCC(confirmMethod = "confirmPayment", cancelMethod = "cancelPayment")
    public Order payment( PaymentVo paymentVo ) {
        return null;
    }

    private void confirmPayment (PaymentVo paymentVo) {
        logger.debug("payment confirm>>>>>>>>>>>>>>>");
    }
    private void cancelPayment (PaymentVo paymentVo) {
        logger.debug("payment cancel>>>>>>>>>>>>>>>");

    }

}
