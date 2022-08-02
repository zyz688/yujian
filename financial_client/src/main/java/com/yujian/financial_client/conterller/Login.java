package com.yujian.financial_client.conterller;

import com.alibaba.druid.util.StringUtils;
import com.yujian.financial_client.pojo.User;
import com.yujian.financial_client.service.UserService;
import com.yujian.financial_client.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
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

    @GetMapping({"/", "/login"})
    public String GoLogin() {



        return "login";



    }


    @PostMapping("/main")
    public String login(User param, Model model, HttpSession session) {

        User user = userService.getOneUser(param);
        System.out.println(param);

        if (user != null) { System.out.println("用户" + param.getName());
            System.out.println("密码" + param.getPasswd());


            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            boolean matches = bCryptPasswordEncoder.matches(param.getPasswd(), user.getPasswd());
            System.out.println("没有加密前"+ matches);
            if (matches) {

                model.addAttribute("loginUser", param.getName());
                session.setAttribute("loginUser", param.getName());
                return "table";}


            }else
                model.addAttribute("msg", "密码或账号错误！请从新登入");

                return "login";


    }

    @RequestMapping("/loginOut")
    public String loginOut( HttpSession session){
        session.removeAttribute("loginUser");

        return  "login";

    }


}