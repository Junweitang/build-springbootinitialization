package cn.t9.root.modules.system.controller;

import cn.t9.root.common.ResultToFront;
import cn.t9.root.common.ResultUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * MvcController 控制跳转至前端
 *
 * @author: junwei_tang
 * @date: 2020-10-24
 * @version: v1.0
 */

@RestController
@RequestMapping("/login")
@Api(value = "登陆相关接口", tags = "登陆相关接口")
public class MvcController {

    @Value("${mvc.prefixUrl}")
    private String prefixUrl;

    @GetMapping(value = "/index")
    @ApiOperation(value = "登陆跳转功能", notes = "登陆跳转功能")
    public void index(HttpServletRequest request, HttpServletResponse response) {

        String token = request.getParameter("token");
        try{

            response.sendRedirect(prefixUrl+"/#access_token="+token);

        } catch (IOException e) {
            System.out.println("/login/index"+e);
        }
    }

    @GetMapping(value = "/logout")
    @ApiOperation(value = "登出功能", notes = "登出功能")
    public ResultToFront<Object> logout(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");

        try {

            return ResultUtil.success("退出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("登出异常");
        }
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
