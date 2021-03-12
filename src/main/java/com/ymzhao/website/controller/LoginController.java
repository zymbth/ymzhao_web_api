package com.ymzhao.website.controller;


import com.ymzhao.website.model.APIResult;
import com.ymzhao.website.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * user informations 前端控制器
 * </p>
 *
 * @author ymzhao
 * @since 2020-03-19
 */
@RestController
@RequestMapping("/zymwb/login")
@Api(tags = {"用户登录服务"})
public class LoginController {

    private LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/log_in", method = RequestMethod.POST)
    public APIResult<String> logIn(@RequestParam String username,
                                 @RequestParam String password) {
        return loginService.logIn(username, password);
    }
}
