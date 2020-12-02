package com.isaac.easy.mysqldbsample.controller;

import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallAccountMapper;
import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallOrderMapper;
import com.isaac.easy.mysqldbsample.mall.dao.secondary.MallOrderMapper2;
import com.isaac.easy.mysqldbsample.mall.module.MallAccount;
import com.isaac.easy.mysqldbsample.mall.module.MallAccountExample;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallOrderExample;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 *
 * @author liangchao
 */
@RestController
@RequestMapping("/mall")
public class MallController {

    @Resource
    private MallAccountMapper mallAccountMapper;
    @Resource
    private MallOrderMapper mallOrderMapper;

    @RequestMapping("/ping")
    public String ping(){

        return "Ping mall!";
    }

    @RequestMapping("/insertOrder")
    public int insertOrder( MallOrder order ) {
        return mallOrderMapper.insert(order);
    }
    @RequestMapping("/queryOrder")
    public List<MallOrder> queryOrder( MallOrder order ) {
        MallOrderExample condition = new MallOrderExample();
        condition.createCriteria().andIdGreaterThan(0L)
                .andIdLessThan(100L);

        return mallOrderMapper.selectByExample(condition);
    }

    @RequestMapping("/insertAccount")
    public int insertAccount( MallAccount account ) {
        MallAccount account1 = new MallAccount();
        account1.setAccountName("insertTest2");
        account1.setSaltPassword("insertTest");
        account1.setCreateTime(System.currentTimeMillis());
        return mallAccountMapper.insert(account1);
    }

}
