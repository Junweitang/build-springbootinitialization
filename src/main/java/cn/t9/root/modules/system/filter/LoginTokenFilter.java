package cn.t9.root.modules.system.filter;

import com.baomidou.mybatisplus.extension.api.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * LoginTokenFilter
 *
 * @author: junwei_tang
 * @date: 2020-10-25
 * @version: v1.0
 */

@Component
public class LoginTokenFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取头部header 信息
        return true;
    }

    /**
     * 错误信息
     *
     * @param response
     * @param msg
     */
    private void error(HttpServletResponse response, String msg) {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json");
        try {
            PrintWriter writer = response.getWriter();
            //将返回的错误提示压入流中
            writer.write(new ObjectMapper().writeValueAsString(R.failed(msg)));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
