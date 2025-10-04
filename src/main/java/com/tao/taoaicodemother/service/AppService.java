package com.tao.taoaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.tao.taoaicodemother.model.dto.app.AppQueryRequest;
import com.tao.taoaicodemother.model.entity.App;
import com.tao.taoaicodemother.model.entity.User;
import com.tao.taoaicodemother.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;


/**
 * 应用 服务层。
 *
 * @author <a href="https://gitee.com/ztao-dev">程序员阿涛</a>
 */
public interface AppService extends IService<App> {

    /**
     * 通过对话生成应用
     *
     * @param appId     应用id
     * @param message   提示词
     * @param loginUser 登录用户
     * @return 生成的代码
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 获取应用封装类
     */
    AppVO getAppVO(App app);

    /**
     * 构造应用查询条件
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 获取应用封装列表
     *
     * @param appList 应用列表
     * @return 应用封装列表
     */
    List<AppVO> getAppVOList(List<App> appList);

}
