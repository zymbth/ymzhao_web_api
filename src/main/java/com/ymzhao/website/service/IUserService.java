package com.ymzhao.website.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ymzhao.website.entity.User;

/**
 * <p>
 * user informations 服务类
 * </p>
 *
 * @author ymzhao
 * @since 2020-03-19
 */
public interface IUserService extends IService<User> {

    IPage<User> getAllUsers(Integer page, Integer pagesize);

    IPage<User> getUsersByType(Integer page, Integer pagesize, Integer typeId);

    Boolean login(String usrname, String pwd);
}
