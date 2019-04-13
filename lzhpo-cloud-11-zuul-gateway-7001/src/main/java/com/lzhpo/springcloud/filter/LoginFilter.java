package com.lzhpo.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：自定义登录过滤器</p>
 * <p> Description：
 * 不带 token参数访问：http://localhost:7001/product/get/1
 * 带 token参数访问：http://localhost:7001/product/get/1?token=123
 * </p>
 */
@Component  //加入容器中
public class LoginFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public String filterType() {
        return "pre";   //请求路由前调用
    }

    @Override
    public int filterOrder() {
        return 1;   //int值来定义过滤器的执行顺序，数值越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;    //该过滤器是否执行，true执行，false不执行
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //获取请求参数token的值
        String token = request.getParameter("token");
        if (token == null){
            logger.warn("此操作需要先登录系统...");
            context.setSendZuulResponse(false); //拒绝访问
            context.setResponseStatusCode(200); //设置相应状态码
            try {
                //相应结果
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
