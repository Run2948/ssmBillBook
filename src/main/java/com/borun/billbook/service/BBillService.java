package com.borun.billbook.service;

import com.borun.billbook.bean.BBill;

import java.util.List;

/**
 * 账单Bill操作接口
 */
public interface BBillService {

    /**
     * 添加账单
     *
     * @param bill
     */
    public int insertBill(BBill bill);

    /**
     * 更新账单
     *
     * @param bill
     */
    public int updateBill(BBill bill);

    /**
     * 删除账单
     *
     * @param billId
     */
    public int deleteBill(int billId);

    /**
     * 根据账单id查询账单
     *
     * @param id
     * @return
     */
    public BBill findBillById(Integer id);

    /**
     * 根据用户id查询账单
     *
     * @param userid
     * @return
     */
    public List<BBill> findBillsByUserId(Integer userid);

    /**
     * 根据用户id查询某年某月某日账单
     *
     * @param userid
     * @param date
     * @return
     */
    public List<BBill> findBillsByUserIdWithYearMouthDay(Integer userid, String date);

    /**
     * 根据用户id查询某年某月某日账单，返回详情
     *
     * @param userid
     * @param date
     * @return
     */
    public List<BBill> findChatsByUserIdWithYSortYM(Integer userid, Integer sortid, String date, boolean income);

    /**
     * 返回每月收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    public String getTotalIncomeByUserIdWithYearMonth(Integer userid, String date);

    public String getTotalOutcomeByUserIdWithYearMonth(Integer userid, String date);

    /**
     * 返回每月每种分类收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    public String getTotalIncomeByUserIdAndSortIdYM(Integer userid, Integer sortid, String date);

    public String getTotalOutcomeByUserIdAndSortIdYM(Integer userid, Integer sortid, String date);

    /**
     * 返回每月每种支付方式收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    public String getTotalIncomeByUserIdWithPayIdYM(Integer userid, Integer sortid, String date);

    public String getTotalOutcomeByUserIdWithPayIdYM(Integer userid, Integer sortid, String date);

    /**
     * 返回每天收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    public String getTotalIncomeByUserIdWithYearMonthDay(Integer userid, String date);

    public String getTotalOutcomeByUserIdWithYearMonthDay(Integer userid, String date);
}
