package com.ymzhao.website.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.ymzhao.website.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Create By ymzhao on 2021/3/11
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    /*@Resource
    private JwtUtil jwtUtil;*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String uri = request.getRequestURI();

        System.out.println("uri: " + uri);

        String headToken = request.getHeader("Authorization");
        if(StringUtils.isEmpty(headToken)) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", 20001);
            map.put("message", "Missing or invalid Authorization header");
            ErrorResponse(response, map);
            return false;
        }
        try {
            Map<String, Claim> map = JwtUtil.verifyToken(headToken);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map = new HashMap<>();
            map.put("code", 20002);
            map.put("message", "Invalid Authorization header " + e.getLocalizedMessage());
            ErrorResponse(response, map);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    // 被拦截的请求响应
    private void ErrorResponse(HttpServletResponse response, Map<String, Object> result){
        OutputStream out = null;

        JSONObject object = new JSONObject();
        object.put("result", result);

        try{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(object.toString().getBytes());
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (out != null) {
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
