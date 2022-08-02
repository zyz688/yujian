package com.yujian.financial_client.service;

import com.yujian.financial_client.pojo.Supply;

import java.util.List;

/**
 * @author ze
 * @create 2022-06-28-17:01
 */

public interface SupplyService {
    List<Supply> allSupply(Integer pa ,Integer limit);
    int addSupply(Supply supply);
    int getDataCount();
    int deleteSupply(String id);

}
