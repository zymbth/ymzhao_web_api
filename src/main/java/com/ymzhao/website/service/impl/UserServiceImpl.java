package com.ymzhao.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymzhao.website.entity.User;
import com.ymzhao.website.mapper.UserMapper;
import com.ymzhao.website.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * user informations 服务实现类
 * </p>
 *
 * @author ymzhao
 * @since 2020-03-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> getAllUsers(Integer page, Integer pagesize) {
        Page<User> page1 = new Page<>(page, pagesize);
        return userMapper.selectPage(page1, new QueryWrapper<User>().orderByAsc("usrtype"));
    }

    @Override
    public IPage<User> getUsersByType(Integer page, Integer pagesize, Integer typeId) {
        Page<User> page1 = new Page<>(page, pagesize);
        return userMapper.selectPage(page1, new QueryWrapper<User>().eq("usrtype", typeId));
    }

    @Override
    public Boolean login(String usrname, String pwd) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("usrname", usrname).eq("pwd", pwd);
        User user = userMapper.selectOne(queryWrapper);
        return user != null && user.getId() != null;
    }
}
