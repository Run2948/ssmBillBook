package com.borun.billbook.service;

import com.borun.billbook.bean.BPay;

import java.util.List;

/**
 * 支付信息payInfo操作接口
 */
public interface BPayService {

    /**
     * 通过用户id查询用户的支付方式，包含系统自带
     *
     * @param id
     * @return
     */
    public List<BPay> findPayinfoByUserId(int id);

    /**
     * 添加支付方式，返回操作数
     *
     * @param bPay
     * @return
     */
    public int addPayinfo(BPay bPay);

    /**
     * 更新支付方式，返回操作数
     *
     * @param bPay
     * @return
     */
    public int updatePayinfo(BPay bPay);

    /**
     * 删除支付方式，返回操作数
     *
     * @param id
     * @return
     */
    public int deletePayinfo(int id);
}
