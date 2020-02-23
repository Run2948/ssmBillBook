package com.borun.billbook.service.impl;

import com.borun.billbook.bean.BPay;
import com.borun.billbook.dao.BPayMapper;
import com.borun.billbook.service.BPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 支付信息payInfo操作类
 */
@Service
public class BPayServiceImpl implements BPayService {

    @Autowired
    private BPayMapper bPayMapper;

    /**
     * 通过用户id查询用户的支付方式，包含系统自带
     *
     * @param id
     * @return
     */
    @Override
    public List<BPay> findPayinfoByUserId(int id) {
        return bPayMapper.selectByUserId(id);
    }

    /**
     * 添加支付方式，返回操作数
     *
     * @param bPay
     * @return
     */
    @Override
    public int addPayinfo(BPay bPay) {
        return bPayMapper.insert(bPay);
    }

    /**
     * 更新支付方式，返回操作数
     *
     * @param bPay
     * @return
     */
    @Override
    public int updatePayinfo(BPay bPay) {
        return bPayMapper.updateByPrimaryKey(bPay);
    }

    /**
     * 删除支付方式，返回操作数
     *
     * @param id
     * @return
     */
    @Override
    public int deletePayinfo(int id) {
        return bPayMapper.deleteByPrimaryKey(id);
    }
}
