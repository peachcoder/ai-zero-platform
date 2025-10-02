package com.tao.taoaicodemother.ai;

import com.tao.taoaicodemother.ai.model.HtmlCodeResult;
import com.tao.taoaicodemother.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.SystemMessage;

/**
 * ClassName: AiCodeGeneratorService
 * Package: com.tao.taoaicodemother.ai
 * Description:
 *
 * @Author zt
 * @Create 2025/10/2 15:33
 * @Version 1.0
 */
public interface AiCodeGeneratorService {
    /**
     * 生成HTML代码
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generateHtmlCode(String userMessage);

    /**
     * 生成多文件代码
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    MultiFileCodeResult generateMultiFileCode(String userMessage);
}
