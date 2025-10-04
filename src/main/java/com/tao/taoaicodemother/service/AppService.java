package com.tao.taoaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.tao.taoaicodemother.model.dto.app.AppQueryRequest;
import com.tao.taoaicodemother.model.entity.App;
import com.tao.taoaicodemother.model.vo.AppVO;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://gitee.com/ztao-dev">程序员阿涛</a>
 */
public interface AppService extends IService<App> {
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
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);
}
