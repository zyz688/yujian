package com.yujian.financial_client.conterller;

import com.alibaba.druid.util.StringUtils;
import com.yujian.financial_client.pojo.User;
import com.yujian.financial_client.service.UserService;
import com.yujian.financial_client.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * @author ze
 * @create 2022-06-21-15:50
 */


@Controller
public class Login {
    @Autowired
    UserService userService;

    @GetMapping({"/","/login"})
        public  String  GoLogin(){

        return "login";


    }






    @PostMapping( "/main")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password, Model model, HttpSession session) {

                System.out.println(name);
                //使用MD5密码校验
        if (!StringUtils.isEmpty(name) && MD5Util.getMD5(password).equals(userService.getPassword(name))) {
            System.out.println("用户" + name);
            System.out.println(  "密码" + password);

            session.setAttribute("loginUser",name);
            return "redirect:/layui.html";

        } else {
                    model.addAttribute("msg", "密码或账号错误！请从新登入");

            return "login";


        }
    }
}