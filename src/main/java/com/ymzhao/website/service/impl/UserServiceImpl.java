package com.ymzhao.website.service.impl;

import com.ymzhao.website.entity.User;
import com.ymzhao.website.mapper.UserMapper;
import com.ymzhao.website.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
