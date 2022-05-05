//package aiden.nowcoder.community.config;
//
//import aiden.nowcoder.community.controller.interceptor.AlphaInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @program: TheRoadToPromotion
// * @description:
// * @author: Mr.Jiang
// * @create: 2022-04-21 00:04
// **/
//@Configuration
//@EnableWebSecurity(debug = true)//已经自动配置了，此处只是为了打印debug信息
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AlphaInterceptor alphaInterceptor;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
//    }
//
//}
