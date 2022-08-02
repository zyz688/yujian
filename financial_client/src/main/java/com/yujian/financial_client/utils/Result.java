package com.yujian.financial_client.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ze
 * @create 2022-07-02-16:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
/**
 *
 *  给前端返回的数据结构
 * "code": 0,
 *   "msg": "",
 *   "count": 1000,
 *   "data": [{}, {}]
 *
 */


 private  long code;
 private String msg;
 private long  count;
 private  T  data;









}
