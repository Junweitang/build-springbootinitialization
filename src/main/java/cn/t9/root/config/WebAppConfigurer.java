package cn.t9.root.config;

import cn.t9.root.modules.system.filter.LoginTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * WebAppConfigurer
 *
 * @author: junwei_tang
 * @date: 2020-10-25
 * @version: v1.0
 */

@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
    @Bean
    LoginTokenFilter loginTokenFilter() {
        return new LoginTokenFilter();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginTokenFilter())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html/**", "/v2/**", "/webjars/**", "/swagger-resources/**");
        super.addInterceptors(registry);
    }

    /**
     * 解决swagger-ui 无法访问
     * 两个方法都需要重写，只加任何一个都无法生效
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
