package com.yujian.financial_client.service;

import com.yujian.financial_client.mapper.SupplyMapper;
import com.yujian.financial_client.pojo.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ze
 * @create 2022-06-28-17:05
 */
@Service
public class SupplyServiceIpm implements SupplyService{

    @Autowired
    SupplyMapper supplyMapper;
    @Override
    public List<Supply> allSupply(Integer pa ,Integer limit) {
        List<Supply> supplyList = supplyMapper.allSupply(pa,limit);


        return supplyList;
    }

    @Override
    public int addSupply(Supply supply) {


        return  supplyMapper.addSupply(supply);
    }

    @Override
    public int getDataCount() {

        return  supplyMapper.getDataCount();
    }

    @Override
    public int deleteSupply(String id) {

        int i = supplyMapper.deleteSupply(id);
        return i;
    }


}
