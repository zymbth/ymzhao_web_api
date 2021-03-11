package com.ymzhao.website.service.impl;

import com.ymzhao.website.model.APIResult;
import com.ymzhao.website.model.APIResultCode;
import com.ymzhao.website.service.LoginService;
import com.ymzhao.website.utils.ConstantsUtil;
import com.ymzhao.website.utils.JwtUtil;
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
public class LoginServiceImpl implements LoginService {

    @Override
    public APIResult<String> logIn(String username, String password) {
        if(ConstantsUtil.USERNAME.equals(username) && ConstantsUtil.PASSWORD.equals(password)) {
            String token;
            try {
                token = JwtUtil.createToken(username);
            } catch (Exception e) {
                e.printStackTrace();
                return APIResult.failure(APIResultCode.FAILURE, "生成token失败");
            }
            return APIResult.success(token);
        }
        return APIResult.failure(APIResultCode.FAILURE, "用户名/密码错误");
    }
}
