package com.yujian.financial_client.mapper;

import com.yujian.financial_client.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ze
 * @create 2022-06-21-20:40
 */
@Mapper
public interface UserMapper {


    public String getPasswd(@Param("name") String name);
    public List<User> getUser();
    public int addUser(User user);
           int updateUser(User user);
           int deleteUser(String name);





}