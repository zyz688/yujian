package com.yujian.financial_client.conterller;

import com.yujian.financial_client.pojo.User;
import com.yujian.financial_client.service.UserService;
import com.yujian.financial_client.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

/**
 * @author ze
 * @create 2022-06-28-14:57
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public  String addUser(@RequestParam("name")String name ,
                           @RequestParam("passwd") String passwd){
        String md5 = MD5Util.getMD5(passwd);//使用MD5加密
        User user = new User(name, md5);
        userService.addUser(user);

        return  "";




    }

    @PostMapping("/updateUser")
    public  String  updateUser(User user , Model model){

        int i = userService.updateUser(user);
        if (i==1){
            model.addAttribute("msg", "success");

        }else {
            model.addAttribute("msg", "failed");

        }
       return  "" ;
    }

    @RequestMapping("/deleteUser/name")
    public  String deleteUser(@PathParam("name") String name ,Model model){


        int i = userService.deleteUser(name);
        if (i==1){
            model.addAttribute("msg", "success");

        }else {
            model.addAttribute("msg", "failed");

        }


        return "";//后期加上表格HTML





    }






}
