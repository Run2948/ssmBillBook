package com.borun.billbook.controller;

import com.borun.billbook.bean.*;
import com.borun.billbook.service.BPayService;
import com.borun.billbook.service.BSortService;
import com.borun.billbook.service.BUserService;
import com.borun.billbook.utils.JsonUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
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
    @Autowired
    private BUserService bUserService;

    @RequestMapping("/default")
    @ResponseBody
    public NoteListBean defaultInfo() {
        NoteListBean noteListBean = bUserService.getUserNodeList(0);
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
        NoteListBean noteListBean = bUserService.getUserNodeList(id);
        noteListBean.setSuccess();
        return noteListBean;
    }

    /**
     * 通过用户id查询收入分类信息
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
     * 添加自定义账单分类
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
        int result = bSortService.updateSort(sort);
        if (result == 0)
            return (BSort2) new BSort2().fail();
        return (BSort2) new BSort2(sort).success();
    }

    /**
     * 通过sortid删除分类信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/sort/delete/{id}")
    @ResponseBody
    public BaseBean deleteSort(@PathVariable("id") Integer id) {
        BaseBean baseBean = new BaseBean();
        if(bSortService.deleteSort(id)> 0)
            return baseBean.success();
        return baseBean.fail("删除失败");
    }

    /**
     * 同步用户自定义sort分类
     *
     * @param id
     * @return
     */
    @RequestMapping("/sort/sync")
    @ResponseBody
    public NoteListBean syncSort(@Param("uid") Integer id, @RequestBody List<BSort> sorts) {

        if (sorts != null && sorts.size() > 0) {
            try {
                System.out.println(JsonUtils.toJSONString(sorts));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        NoteListBean noteListBean = bUserService.getUserNodeList(id);
        noteListBean.setSuccess();
        return noteListBean;
    }

    /**
     * 通过payid删除支付方式
     *
     * @param id
     * @return
     */
    @RequestMapping("/pay/delete/{id}")
    @ResponseBody
    public BaseBean deletePay(@PathVariable("id") Integer id) {
        BaseBean baseBean = new BaseBean();
        if(bPayService.deletePayinfo(id)> 0)
           return baseBean.success();
        return baseBean.fail("删除失败");
    }

    /**
     * 通过payid查询支付方式
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
     * 添加自定义支付方式
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

    /**
     * 同步用户自定义支付方式
     *
     * @param id
     * @return
     */
    @RequestMapping("/pay/sync")
    @ResponseBody
    public NoteListBean syncPay(@Param("uid") Integer id, @RequestBody List<BPay> pays) {

        if (pays != null && pays.size() > 0) {
            try {
                System.out.println(JsonUtils.toJSONString(pays));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        NoteListBean noteListBean = bUserService.getUserNodeList(id);
        noteListBean.setSuccess();
        return noteListBean;
    }
}
