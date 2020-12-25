package com.easy.hmily.api;

import com.easy.hmily.entity.Account;
import com.easy.hmily.entity.Order;
import com.easy.hmily.entity.PaymentVo;
import org.dromara.hmily.annotation.Hmily;

/**
 * @author think
 * @date 2020/12/23
 */
public interface IPaymentService {
    @Hmily
    Order payment( PaymentVo paymentVo );
}
