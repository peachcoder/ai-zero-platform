package com.tao.taoaicodemother.core;

/**
 * ClassName: AiCodeGeneratorFacade
 * Package: com.tao.taoaicodemother.core
 * Description:
 *
 * @Author zt
 * @Create 2025/10/2 18:33
 * @Version 1.0
 */

import com.tao.taoaicodemother.ai.AiCodeGeneratorService;
import com.tao.taoaicodemother.ai.model.HtmlCodeResult;
import com.tao.taoaicodemother.ai.model.MultiFileCodeResult;
import com.tao.taoaicodemother.exception.BusinessException;
import com.tao.taoaicodemother.exception.ErrorCode;
import com.tao.taoaicodemother.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * AI 代码生成门面类、组合代码生成和保存功能
 */
@Service
public class AiCodeGeneratorFacade {
    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    /**
     * 统一入口，根据类型生成并保存代码
     */
    public File generateAndSaveCode(String userMessage, CodeGenTypeEnum codeGenTypeEnum) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "生成类型不能为空");
        }
        return switch (codeGenTypeEnum) {
            case HTML -> generateAndSaveHtmlCode(userMessage);
            case MULTI_FILE -> generateAndSaveMultiFileCode(userMessage);
            default -> {
                String errorMessage = "不支持的生成类型：" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }

    /**
     * 生成HTML 模式的代码并保存
     * @param userMessage 用户提示词
     * @return 保存的目录
     */

    private File generateAndSaveHtmlCode(String userMessage) {
        HtmlCodeResult htmlCodeResult = aiCodeGeneratorService.generateHtmlCode(userMessage);
        return CodeFileSaver.saveHtmlCodeResult(htmlCodeResult);
    }

    /**
     * 生成多文件模式的代码并保存
     * @param userMessage 用户提示词
     * @return 保存的目录
     */
    private File generateAndSaveMultiFileCode(String userMessage) {
        MultiFileCodeResult multiFileCodeResult = aiCodeGeneratorService.generateMultiFileCode(userMessage);
        return CodeFileSaver.saveMultiFileCodeResult(multiFileCodeResult);
    }
}
