package com.tao.taoaicodemother.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.tao.taoaicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.tao.taoaicodemother.model.entity.ChatHistory;
import com.tao.taoaicodemother.model.entity.User;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author <a href="https://gitee.com/ztao-dev">程序员阿涛</a>
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加对话历史
     *
     * @param appId       应用id
     * @param message     消息
     * @param messageType 消息类型
     * @param userId      用户id
     * @return 是否成功
     */
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    /**
     * 根据应用id删除对话记录
     *
     * @param appId 应用id
     * @return 是否成功
     */
    boolean deleteByAppId(Long appId);

    /**
     * 构造查询条件
     *
     * @param chatHistoryQueryRequest 查询条件
     * @return 查询参数
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);

    /**
     * 分页查询某 APP 的对话记录
     *
     * @param appId          应用id
     * @param pageSize       每页大小
     * @param lastCreateTime 上次查询时间
     * @param loginUser      登录用户
     * @return
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    /**
     * 加载对话历史到内存
     * @param appId 应用id
     * @param chatMemory 缓存
     * @param maxCount 最大数量
     * @return 加载成功的条数
     */
    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);
}
