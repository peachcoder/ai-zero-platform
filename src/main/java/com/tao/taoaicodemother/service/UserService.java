package com.tao.taoaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.tao.taoaicodemother.model.dto.user.UserQueryRequest;
import com.tao.taoaicodemother.model.entity.User;
import com.tao.taoaicodemother.model.vo.LoginUserVO;
import com.tao.taoaicodemother.model.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 用户 服务层。
 *
 * @author <a href="https://gitee.com/ztao-dev">程序员阿涛</a>
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return 脱敏的已登录用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取脱敏后的用户信息
     *
     * @param user 用户信息
     * @return 脱敏的当前登录用户信息
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏后的用户信息
     * @param userList 用户列表
     * @return 脱敏后的用户信息
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request      登录请求
     * @return 脱敏的已登录用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取加密密码
     * @param userPassword  用户密码
     * @return  加密后的用户密码
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取当前登录用户
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户注销
     * @param request 请求
     * @return 退出登录是否成功
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 根据查询条件构造数据查询参数
     *
     * @param userQueryRequest 查询条件
     * @return 查询参数
     */
    QueryWrapper getQueryWrapper(UserQueryRequest userQueryRequest);
}
