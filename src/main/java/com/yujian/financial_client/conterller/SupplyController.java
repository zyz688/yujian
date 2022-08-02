package com.yujian.financial_client.conterller;

import com.yujian.financial_client.pojo.Supply;
import com.yujian.financial_client.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ze
 * @create 2022-06-28-17:00
 */

@Controller
public class SupplyController {
    @Autowired
    SupplyService supplyService;

    @RequestMapping(value = "/allSupply",produces = "application/json")
    @ResponseBody
    public  List<Supply> allSupply(Model model){
        List<Supply> supplyList = supplyService.allSupply();
//        model.addAttribute("supplyList",supplyList);

        return  supplyList;


    }

}
