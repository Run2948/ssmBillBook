package com.borun.billbook.bean;

import java.util.List;

/**
 * 月账单报表信息
 */
public class MonthChartListBean extends BaseBean {

    String totalOut;    //总支出
    String totalIn;    //总收入
    String l_totalOut;  //上月总支出
    String l_totalIn;  //上月总收入
    List<SortTypeList> outSortlist;    //账单分类统计支出
    List<SortTypeList> InSortlist;    //账单分类统计收入

    public String getTotalOut() {
        return totalOut;
    }

    public void setTotalOut(String totalOut) {
        this.totalOut = totalOut;
    }

    public String getTotalIn() {
        return totalIn;
    }

    public void setTotalIn(String totalIn) {
        this.totalIn = totalIn;
    }

    public String getL_totalOut() {
        return l_totalOut;
    }

    public void setL_totalOut(String l_totalOut) {
        this.l_totalOut = l_totalOut;
    }

    public String getL_totalIn() {
        return l_totalIn;
    }

    public void setL_totalIn(String l_totalIn) {
        this.l_totalIn = l_totalIn;
    }

    public List<SortTypeList> getOutSortlist() {
        return outSortlist;
    }

    public void setOutSortlist(List<SortTypeList> outSortlist) {
        this.outSortlist = outSortlist;
    }

    public List<SortTypeList> getInSortlist() {
        return InSortlist;
    }

    public void setInSortlist(List<SortTypeList> inSortlist) {
        InSortlist = inSortlist;
    }

    public static class SortTypeList {
        private String back_color;
        private String  money;    //此分类下的当月总收支
        private BSort sort;    //此分类
        private List<BBill> list;  //此分类下的当月账单

        public String getBack_color() {
            return back_color;
        }

        public void setBack_color(String back_color) {
            this.back_color = back_color;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public List<BBill> getList() {
            return list;
        }

        public void setList(List<BBill> list) {
            this.list = list;
        }

        public BSort getSort() {
            return sort;
        }

        public void setSort(BSort sort) {
            this.sort = sort;
        }
    }
}
