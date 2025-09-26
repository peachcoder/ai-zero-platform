package com.tao.taoaicodemother.controller;

import com.tao.taoaicodemother.common.BaseResponse;
import com.tao.taoaicodemother.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HealthController
 * Package: com.tao.taoaicodemother.controller
 * Description:
 *
 * @Author zt
 * @Create 2025/9/27 0:23
 * @Version 1.0
 */
@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/")
    public BaseResponse<String> healthCheck(){
        return ResultUtils.success("ok");
    }
}
