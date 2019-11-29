package com.example.shiroDemo.controller;

import com.sun.org.apache.bcel.internal.classfile.Unknown;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

import javax.jws.WebParam;

@Controller
public class TestController {

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
}
