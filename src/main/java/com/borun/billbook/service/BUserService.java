package com.borun.billbook.service;

import com.borun.billbook.bean.BUser;

/**
 * 用户User操作接口
 */
public interface BUserService {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public BUser register(BUser user);

    /**
     * 用户登陆检测
     *
     * @param user
     * @return
     */
    public BUser checkLogin(BUser user);

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     */
    public BUser findUserById(Integer id);

    /**
     * 根据用户username查询用户
     *
     * @param name
     * @return
     */
    public BUser findUserByUserName(String name);

    /**
     * 注册邮箱验证
     *
     * @param code
     * @return
     */
    public BUser verifyMail(String code);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public int updateUser(BUser user);
}
