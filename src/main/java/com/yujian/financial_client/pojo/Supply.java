package com.yujian.financial_client.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 * @author ze
 * @create 2022-06-28-14:12
 */

//供货表映射对象
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Supply {


    private Date time ;//日期
    private String type;//类别
    private long id;//单号
    private String itemType;//物料类型
    private double payAmount;//支付金额
    private double procurement;//采购金额
    private double balance;//欠款
    private double invoiceAmount;//开票金额
    private double total;//总数
    private String notes;//备注




}
