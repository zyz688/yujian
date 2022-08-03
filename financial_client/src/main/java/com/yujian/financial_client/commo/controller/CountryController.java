package com.yujian.financial_client.commo.controller;

import com.yujian.financial_client.pojo.component.Country;
import com.yujian.financial_client.service.component.CountryService;
import com.yujian.financial_client.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ze
 * @version 1.0
 * @time 2022/7/20 9:49
 */
@Controller
public class CountryController {


    @Autowired
    CountryService countryService;

    @RequestMapping("/country")
    public String country(){



        return "component/countryTable";

    }



    @RequestMapping("/getAllCountry")
    @ResponseBody
    public CommonResult getAllCountry(){


        return CommonResult.success(countryService.getCount(),  countryService.getAllCountry());


    }








    @RequestMapping("/addCountry")
    @ResponseBody
    public  CommonResult addCountry(Country country){


        try {
            countryService.addCountry(country);
        } catch (Exception e) {
           return  CommonResult.failed("国家已经存在");
        }
           return  CommonResult.success();

    }


    @RequestMapping("/addCountryForm")
    public String   addCountryForm(){



        return   "component/countryAdd";
    }



    @RequestMapping("/deleteCountry")
    @ResponseBody
    public CommonResult deleteCountry(Integer id){

        try {
            countryService.deleteCountry(id);
        } catch (Exception e) {
           return CommonResult.failed();
        }

        return CommonResult.success();
    }

}
