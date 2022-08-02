package com.yujian.financial_client.pojo;

import lombok.*;

/**
 * @author ze
 * @create 2022-06-21-15:41user
 */

//登入用户
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {


    private  String name;
    private  String  passwd;

}
