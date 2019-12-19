package com.example.shiroDemo.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManage") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器：
         *      anon: 无需认证（登录）可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */

        Map<String, String> shiroMap = new LinkedHashMap<>();
//        shiroMap.put("/add", "authc");
//        shiroMap.put("/test", "anon");
//        shiroMap.put("/login", "anon");

        //授权过滤器
        //当前授权拦截后，shiro会自动转跳到未授权页面
//        shiroMap.put("/add", "perms[add]");

//        shiroMap.put("/*", "authc");

        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroMap);
        return shiroFilterFactoryBean;
    }

    @Bean(value = "securityManage")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean(value = "userRealm")
    public UserRealm userRealm() {
        UserRealm userReal = new UserRealm();
        return userReal;
    }
}
