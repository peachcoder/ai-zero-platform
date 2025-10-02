package com.tao.taoaicodemother.core;

import com.tao.taoaicodemother.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * ClassName: AiCodeGeneratorFacadeTest
 * Package: com.tao.taoaicodemother.core
 * Description:
 *
 * @Author zt
 * @Create 2025/10/2 19:00
 * @Version 1.0
 */
@SpringBootTest
class AiCodeGeneratorFacadeTest {

    @Resource
    private AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateAndSaveCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("生成一个登录页面，总共不超过20行代码", CodeGenTypeEnum.MULTI_FILE);
        Assertions.assertNotNull(file);
    }
}