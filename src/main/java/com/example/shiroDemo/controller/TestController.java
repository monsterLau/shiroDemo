package com.example.shiroDemo.controller;

import com.example.shiroDemo.aspect.WebLog;
import com.example.shiroDemo.service.UserService;
import com.sun.org.apache.bcel.internal.classfile.Unknown;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.catalina.User;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;

@Controller
public class TestController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "test")
    public String hello() {
        return "test";
    }

    @RequestMapping("add")
    public String add(Model model) {
        return "/user/add";
    }

    @RequestMapping("update")
    public String update(Model model) {
        return "/user/update";
    }

    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping("login")
    @WebLog(description = "用户登录")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        //3.执行登录
        try {
            subject.login(token);
            return "redirect:/test";
        } catch (UnknownAccountException e) {
            //登录失败，用户名不存在
            model.addAttribute("msg", "用户不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @RequestMapping("insertUser")
    public String insert(String userName, String password) {
        userService.insertUser(userName, password);
        return "";
    }

    @RequestMapping("unAuth")
    public String unAuth() {
        return "/unAuth";
    }
}
