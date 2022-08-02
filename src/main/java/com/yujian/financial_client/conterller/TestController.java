package com.yujian.financial_client.conterller;

import com.yujian.financial_client.pojo.User;
import com.yujian.financial_client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ze
 * @create 2022-06-22-13:06
 */
@Controller
public class TestController {

    @Autowired
    UserService service ;

    @GetMapping("/test")
    @ResponseBody
    public  String  test(){
        System.out.println(service.getUser());

   return "成功";
    }

    @GetMapping("/layuitest")
    public  String layuitest(){

        return "layuitest";


    }

}
