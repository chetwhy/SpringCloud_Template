package com.chetwhy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/8/25 16:32
 * @Version 1.0
 */
@Component
public class LoginFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 过滤器类型：
     * pre: 路由前
     * routing: 路由时
     * post: 路由后
     * error: 路由发生错误时
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("{} >>> {}",request.getMethod(),request.getRequestURI());
        String token = request.getParameter("token");
        if (token == null) {
            logger.error("Error! Request Token is Empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("Request token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
