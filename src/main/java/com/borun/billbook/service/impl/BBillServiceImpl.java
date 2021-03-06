package com.borun.billbook.service.impl;

import com.borun.billbook.bean.BBill;
import com.borun.billbook.dao.BBillMapper;
import com.borun.billbook.service.BBillService;
import com.borun.billbook.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账单Bill操作类
 */
@Service
public class BBillServiceImpl implements BBillService {

    @Autowired
    private BBillMapper bBillMapper;

    /**
     * 添加账单
     *
     * @param bill
     */
    @Override
    public int insertBill(BBill bill) {
        return bBillMapper.insert(bill);
    }

    /**
     * 更新账单
     *
     * @param bill
     */
    @Override
    public int updateBill(BBill bill) {
        return bBillMapper.updateByPrimaryKeySelective(bill);
    }

    /**
     * 删除账单
     *
     * @param billId
     */
    @Override
    public int deleteBill(int billId) {
        return bBillMapper.deleteByPrimaryKey(billId);
    }

    /**
     * 根据账单id查询账单
     *
     * @param id
     * @return
     */
    @Override
    public BBill findBillById(Integer id) {
        return bBillMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户id查询账单
     *
     * @param userid
     * @return
     */
    @Override
    public List<BBill> findBillsByUserId(Integer userid) {
        return bBillMapper.selectByUserId(userid);
    }

    /**
     * 根据用户id查询某年某月某日账单
     *
     * @param userid
     * @param date
     * @return
     */
    @Override
    public List<BBill> findBillsByUserIdWithYearMouthDay(Integer userid, String date) {
        return bBillMapper.selectBillsByUserIdWithSortYMD(userid, date);
    }

    /**
     * 根据用户id查询某年某月某日账单，返回详情
     *
     * @param userid
     * @param date
     * @return
     */
    @Override
    public List<BBill> findChatsByUserIdWithYSortYM(Integer userid, Integer sortid, String date, boolean income) {
        if (income)
            return bBillMapper.selectInBillsByUserIdAndSortIdWithSortYM(userid, sortid, date);
        return bBillMapper.selectOutBillsByUserIdAndSortIdWithSortYM(userid, sortid, date);
    }

    /**
     * 返回每月收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    @Override
    public String getTotalIncomeByUserIdWithYearMonth(Integer userid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithYearMonth(userid, date));
    }

    @Override
    public String getTotalOutcomeByUserIdWithYearMonth(Integer userid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithYearMonth(userid, date));
    }

    /**
     * 返回每月每种分类收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    @Override
    public String getTotalIncomeByUserIdAndSortIdYM(Integer userid, Integer sortid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithSortIdYM(userid, sortid, date));
    }

    @Override
    public String getTotalOutcomeByUserIdAndSortIdYM(Integer userid, Integer sortid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithSortIdYM(userid, sortid, date));
    }

    /**
     * 返回每月每种支付方式收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    @Override
    public String getTotalIncomeByUserIdWithPayIdYM(Integer userid, Integer sortid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithPayIdYM(userid, sortid, date));
    }

    @Override
    public String getTotalOutcomeByUserIdWithPayIdYM(Integer userid, Integer sortid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithPayIdYM(userid, sortid, date));
    }

    /**
     * 返回每天收支情况，返回总额
     *
     * @param userid
     * @param date
     * @return
     */
    @Override
    public String getTotalIncomeByUserIdWithYearMonthDay(Integer userid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalIncomeByUserIdWithYearMonthDay(userid, date));
    }

    @Override
    public String getTotalOutcomeByUserIdWithYearMonthDay(Integer userid, String date) {
        return StringUtils.null2Zero(bBillMapper.getTotalOutcomeByUserIdWithYearMonthDay(userid, date));
    }
}
