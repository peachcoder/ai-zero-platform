package com.tao.taoaicodemother.ai.model;

/**
 * ClassName: HtmlCodeResult
 * Package: com.tao.taoaicodemother.ai.model
 * Description:
 *
 * @Author zt
 * @Create 2025/10/2 16:55
 * @Version 1.0
 */

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

/**
 * HTML代码生成结果
 */
@Description("生成 HTML 代码文件的结果")
@Data
public class HtmlCodeResult {
    /**
     * HTML代码
     */
    @Description("HTML代码")
    private String htmlCode;

    /**
     * 描述
     */
    @Description("生成代码的描述")
    private String description;
}
