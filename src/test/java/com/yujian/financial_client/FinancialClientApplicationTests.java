package com.yujian.financial_client;

import com.yujian.financial_client.mapper.SupplyMapper;
import com.yujian.financial_client.mapper.UserMapper;
import com.yujian.financial_client.pojo.User;
import com.yujian.financial_client.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinancialClientApplicationTests {



    @Autowired
    UserMapper userMapper;
    @Autowired
    SupplyMapper supplyMapper;

    @Test
    void contextLoads() {

        System.out.println(userMapper.getPasswd("123"));
    }


    @Test
    void  testSupply(){
        System.out.println(supplyMapper.allSupply());


    }

    @Test
    void  testMD5(){

        System.out.println(MD5Util.getMD5("AABBC2"));

    }

    @Test
    void testMd5(){

        String name  = "md";
        String passwd =  MD5Util.getMD5("123456");

        User user = new User(name,passwd);
        int i = userMapper.addUser(user);
        System.out.println(i);


    }


    @Test
    void  testMd5Update(){


        userMapper.updateUser( new  User("财务",MD5Util.getMD5("666666")));


    }

}
