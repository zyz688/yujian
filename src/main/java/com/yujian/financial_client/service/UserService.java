package com.yujian.financial_client.service;

import com.yujian.financial_client.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ze
 * @create 2022-06-21-20:57
 */


public interface UserService {

    public  String  getPassword(String name);
    public List<User> getUser();
    public  int      addUser(User user);
    public  int    updateUser(User user);
    public  int    deleteUser(String name);






}
