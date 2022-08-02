package com.yujian.financial_client.mapper;
import com.yujian.financial_client.pojo.Supply;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ze
 * @create 2022-06-28-16:51
 */


@Mapper
public interface SupplyMapper {
     public List<Supply> allSupply(Integer pa ,Integer limit);
     public int deleteSupply(String id);
     public int addSupply(Supply supply);
     public int getDataCount();
}
