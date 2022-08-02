package com.yujian.financial_client.mapper;

import com.yujian.financial_client.pojo.Supply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ze
 * @create 2022-06-28-16:51
 */
@Mapper
public interface SupplyMapper {
     public List<Supply> allSupply();
}
