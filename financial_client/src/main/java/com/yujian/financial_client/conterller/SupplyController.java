package com.yujian.financial_client.conterller;

import com.yujian.financial_client.pojo.Supply;
import com.yujian.financial_client.service.SupplyService;
import com.yujian.financial_client.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//    @RequestMapping("/allSupply")
//    public String allSupply(Model model) {
//        List<Supply> supplys = supplyService.allSupply();
//       model.addAttribute("supplys",supplys);
//
//        return "test";
//
//
//    }


    @RequestMapping(value = {"/allSupply"}, produces = {"application/json"})
    @ResponseBody
    public CommonResult<List<Supply>> allSupply(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        System.out.println(page);
        System.out.println(limit);


        Integer pa = 1;
        Integer li = 5;
        if (page != null) {
            pa = page;
        }
        if (limit != null) {

            li = limit;
        }
        List<Supply> supplyList = supplyService.allSupply(pa, li);
        int dataCount = supplyService.getDataCount();

        CommonResult<List<Supply>> success = CommonResult.success(dataCount, supplyList);
        return success;
    }

    @RequestMapping("/deleteSupply")
    public String deleteSupply(@RequestParam("id") String id) {

        int i = supplyService.deleteSupply(id);
        System.out.println("id为" + id);


        return "table";
    }


    @RequestMapping("/supplyfrom")
    public String supplyfrom() {


        return "supplyfrom";

    }


    @RequestMapping("/addSupply")
    @ResponseBody
    public String addSupply(Supply supply){
        int i = supplyService.addSupply(supply);
        System.out.println(i);
        System.out.println(supply);



        return  "成功";


    }

}
