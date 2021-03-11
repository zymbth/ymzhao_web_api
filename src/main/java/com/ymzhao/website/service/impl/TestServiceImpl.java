package com.ymzhao.website.service.impl;

import com.ymzhao.website.model.APIResult;
import com.ymzhao.website.service.TestService;
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
public class TestServiceImpl implements TestService {

    @Override
    public APIResult<Void> demo() {
        return APIResult.success();
    }
}
