package com.notejava.jwt;

import com.notejava.bo.ApiResult;
import com.notejava.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 用户未登录异常处理类
 * </p>
 * 当用户尝试访问需要权限才能的REST资源而不提供Token或者Token错误或者过期时，
 * 将调用此方法发送401响应以及错误信息
 *
 * @author lyle
 * @since 2020-06-30
 */
@Slf4j
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.error("", authException);
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().println(JacksonUtil.toJsonString(ApiResult.fail(authException.getMessage())));
        response.getWriter().flush();
    }
}
