package com.yujian.financial_client;

import com.alibaba.druid.pool.DruidDataSource;
import com.yujian.financial_client.mapper.SupplyMapper;
import com.yujian.financial_client.mapper.UserMapper;
import com.yujian.financial_client.pojo.Supply;
import com.yujian.financial_client.pojo.User;
import com.yujian.financial_client.utils.MD5Util;
import com.yujian.financial_client.utils.ResultCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        System.out.println(supplyMapper.allSupply(0,5));


    }

    @Test
    void  testMD5(){

       userMapper.getOneUser(new User("123","123456"));

    }

    @Test
    void testMd5(){

        String name  = "666666";
        String passwd =  MD5Util.getMD5("666666");

        User user = new User(name,passwd);
        int i = userMapper.addUser(user);
        System.out.println(i==1?"成功添加":false);


    }


    @Test
    void  testMd5Update(){

//        System.out.println(supplyMapper.allSupply(0,5));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }

    @Test
    void  testInsert(){
        Supply supply = new Supply("2001-1-2", "8", 45454, "88", 4454, 454, 44, 44, 44, "4");
        supplyMapper.addSupply(supply);
    }

}
