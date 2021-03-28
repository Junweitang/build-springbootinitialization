package cn.ffcs.eda.mqmessage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author: junwei_tang
 * @date: 2020-08-19
 * @version: v1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 解决后端跨域问题
     * @param registry
     *@return: void
     *@Author: junwei_tang
     *@date: 2020-08-19 11:17
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
