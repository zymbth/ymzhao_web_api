package com.ymzhao.website.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ymzhao.website.entity.User;
import com.ymzhao.website.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * user informations 前端控制器
 * </p>
 *
 * @author ymzhao
 * @since 2020-03-19
 */
@RestController
@RequestMapping("/website/user")
@Api(tags = {"用户服务"})
public class UserController {

    private IUserService iUserService;
    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @ApiOperation(value = "根据ID获取用户", response = User.class, responseContainer = "List")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public User query(@PathVariable int id) {
        return iUserService.getById(id);
    }

    @ApiOperation(value = "获取全部用户", notes = "分页返回用户列表", response = User.class, responseContainer = "List")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public IPage<User> getAllUsers(@RequestParam(required = false, defaultValue = "1") Integer page,
                                   @RequestParam(required = false, defaultValue = "20") Integer pagesize) {
        return iUserService.getAllUsers(page, pagesize);
    }

    @ApiOperation(value = "获取指定类型用户", notes = "分页返回指定类型用户列表", response = User.class, responseContainer = "List")
    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
    public IPage<User> getAllUsers(@RequestParam(required = false, defaultValue = "1") Integer page,
                                   @RequestParam(required = false, defaultValue = "20") Integer pagesize,
                                   @PathVariable Integer id) {
        return iUserService.getUsersByType(page, pagesize, id);
    }

    @ApiOperation(value = "用户登录验证")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Boolean query(@RequestParam String usrname, @RequestParam String pwd) {
        return iUserService.login(usrname, pwd);
    }
}
