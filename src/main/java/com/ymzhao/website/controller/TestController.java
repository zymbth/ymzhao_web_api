package com.ymzhao.website.controller;


import com.ymzhao.website.model.APIResult;
import com.ymzhao.website.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * user informations 前端控制器
 * </p>
 *
 * @author ymzhao
 * @since 2021-03-11
 */
@RestController
@RequestMapping("/test")
@Api(tags = {"测试服务"})
public class TestController {

    private TestService testService;
    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public APIResult<Void> demo() {
        return testService.demo();
    }
}
