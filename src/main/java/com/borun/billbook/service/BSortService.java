package com.borun.billbook.service;

import com.borun.billbook.bean.BSort;

import java.util.List;

/**
 * 账单分类Sort操作接口
 */
public interface BSortService {

    /**
     * 通过用户id查询用户的支出账单分类，包含系统自带
     *
     * @param id
     * @return
     */
    public List<BSort> findOutSortByUserId(int id);

    /**
     * 通过用户id查询用户的收入账单分类，包含系统自带
     *
     * @param id
     * @return
     */
    public List<BSort> findInSortByUserId(int id);

    /**
     * 通过sortid查询用户的账单分类信息
     *
     * @param id
     * @return
     */
    public BSort findSortById(int id);

    /**
     * 修改账单分类，返回操作数
     *
     * @param bSort
     * @return
     */
    public int updateSort(BSort bSort);

    /**
     * 添加账单分类，返回操作数
     *
     * @param bSort
     * @return
     */
    public int addSort(BSort bSort);

    /**
     * 删除账单分类，返回操作数
     *
     * @param id
     * @return
     */
    public int deleteSort(int id);
}
