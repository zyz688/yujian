package com.yujian.financial_client.service;

import com.yujian.financial_client.mapper.UserMapper;
import com.yujian.financial_client.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ze
 * @create 2022-06-21-21:00
 */
@Service
public class UserServiceIpm  implements UserService{


    @Autowired
    UserMapper userMapper;


    @Override
    public String getPassword(String name) {// 用于密码校验
        String password = userMapper.getPasswd(name);



        return password;
    }

    @Override
    public User getOneUser(User user) {
    return     userMapper.getOneUser(user);
    }

    @Override
    public List<User> getUser() { //查询用户

    List<User> list = new ArrayList<>();
        list.addAll(userMapper.getUser());
        return list;


    }

    @Override
    public int addUser(User user) { //添加用户
        int i =0;
        try {
             i = userMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return  -1;
        }

        return  i;
    }

    @Override
    public int updateUser(User user ) {   //更新密码

        int i = 0;

        try {
            i = userMapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return  -1;
        }

return i;
    }

    @Override
    public int deleteUser(String name) {
        int i = 0;

        try {
            i=  userMapper.deleteUser(name);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return  i;
    }


}
