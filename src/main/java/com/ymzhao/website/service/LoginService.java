package com.ymzhao.website.service;

import com.ymzhao.website.model.APIResult;

/**
 * <p>
 * user informations 服务类
 * </p>
 *
 * @author ymzhao
 * @since 2020-03-19
 */
public interface LoginService {

    APIResult<String> logIn(String username, String password);
}
