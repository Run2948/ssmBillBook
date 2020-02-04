package com.borun.billbook.controller;

import com.borun.billbook.bean.BPay;
import com.borun.billbook.bean.BPay2;
import com.borun.billbook.bean.BSort;
import com.borun.billbook.bean.BSort2;
import com.borun.billbook.bean.NoteListBean;
import com.borun.billbook.service.BPayService;
import com.borun.billbook.service.BSortService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 账单分类Sort和支付方式Payinfo控制类
 */
@Controller
@RequestMapping("note")
public class BNoteController {

    @Autowired
    private BSortService bSortService;
    @Autowired
    private BPayService bPayService;

    @RequestMapping("/default")
    @ResponseBody
    public NoteListBean defaultInfo() {
        NoteListBean noteListBean = new NoteListBean();
        noteListBean.setInSortlis(bSortService.findInSortByUserId(0));
        noteListBean.setOutSortlis(bSortService.findOutSortByUserId(0));
        noteListBean.setPayinfo(bPayService.findPayinfoByUserId(0));
        noteListBean.setSuccess();
        return noteListBean;
    }

    /**
     * 通过用户id查询支付分类信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/{id}")
    @ResponseBody
    public NoteListBean userNoteinfo(@PathVariable("id") Integer id) {
        NoteListBean noteListBean = new NoteListBean();
        noteListBean.setInSortlis(bSortService.findInSortByUserId(id));
        noteListBean.setOutSortlis(bSortService.findOutSortByUserId(id));
        noteListBean.setPayinfo(bPayService.findPayinfoByUserId(id));
        noteListBean.setSuccess();
        return noteListBean;
    }

    /**
     * 通过sortid查询分类信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/sort/{id}")
    @ResponseBody
    public List<BSort> sortinfo(@PathVariable("id") Integer id) {
        return bSortService.findInSortByUserId(id);
    }


    /**
     * 添加账单分类
     *
     * @param uid
     * @param sortName
     * @param sortImg
     * @param income
     * @return
     */
    @RequestMapping("/sort/add")
    @ResponseBody
    public BSort2 addSort(@Param("uid") Integer uid, @Param("sortName") String sortName,
                          @Param("sortImg") String sortImg, @Param("income") Boolean income) {
        BSort sort = new BSort(uid, sortName, sortImg, income);
        int result = bSortService.addSort(sort);
        if (result == 0)
            return (BSort2) new BSort2().fail();
        return (BSort2) new BSort2(sort).success();
    }

    /**
     * 修改自定义sort分类
     *
     * @param id
     * @param uid
     * @param sortName
     * @param sortImg
     * @param income
     * @return
     */
    @RequestMapping("/sort/update")
    @ResponseBody
    public BSort2 updateSort(@Param("id") Integer id, @Param("uid") Integer uid, @Param("sortName") String sortName,
                             @Param("sortImg") String sortImg, @Param("income") Boolean income) {
        BSort sort = new BSort(id, uid, sortName, sortImg, null, income);
        int result = bSortService.addSort(sort);
        if (result == 0)
            return (BSort2) new BSort2().fail();
        return (BSort2) new BSort2(sort).success();
    }

    /**
     * 通过payid查询分类信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/pay/delete/{id}")
    @ResponseBody
    public List<BPay> deletePay(@PathVariable("id") Integer id) {
        return bPayService.findPayinfoByUserId(id);
    }

    /**
     * 通过payid查询分类信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/pay/{id}")
    @ResponseBody
    public List<BPay> payinfo(@PathVariable("id") Integer id) {
        return bPayService.findPayinfoByUserId(id);
    }

    /**
     * 添加支付信息
     *
     * @param uid
     * @param payName
     * @param payImg
     * @param payNum
     * @return
     */
    @RequestMapping("/pay/add")
    @ResponseBody
    public BPay2 addPay(@Param("uid") Integer uid, @Param("payName") String payName,
                        @Param("payImg") String payImg, @Param("payNum") String payNum) {
        BPay pay = new BPay(uid, payName, payImg, payNum);
        int result = bPayService.addPayinfo(pay);
        if (result == 0)
            return (BPay2) new BPay2().fail();
        return (BPay2) new BPay2(pay).success();
    }

    /**
     * 修改自定义支付方式
     *
     * @param id
     * @param uid
     * @param payName
     * @param payImg
     * @param payNum
     * @return
     */
    @RequestMapping("/pay/update")
    @ResponseBody
    public BPay2 addPay(@Param("id") Integer id, @Param("uid") Integer uid, @Param("payName") String payName,
                        @Param("payImg") String payImg, @Param("payNum") String payNum) {
        BPay pay = new BPay(id, uid, payName, payImg, payNum);
        int result = bPayService.addPayinfo(pay);
        if (result == 0)
            return (BPay2) new BPay2().fail();
        return (BPay2) new BPay2(pay).success();
    }

}
