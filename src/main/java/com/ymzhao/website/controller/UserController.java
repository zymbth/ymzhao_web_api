package com.ymzhao.website.controller;


import com.ymzhao.website.entity.User;
import com.ymzhao.website.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/website/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/queryById/{id}", method = RequestMethod.POST)
    public User query(@PathVariable int id) {
        return iUserService.getById(id);
    }
}
