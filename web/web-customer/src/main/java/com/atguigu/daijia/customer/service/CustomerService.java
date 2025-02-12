package com.atguigu.daijia.customer.service;

import com.atguigu.daijia.model.form.customer.UpdateWxPhoneForm;
import com.atguigu.daijia.model.vo.customer.CustomerLoginVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface CustomerService {


    String login(String code);

    //获取用户信息
    CustomerLoginVo getCustomerLoginInfo(String token);
    //获取用户信息
    CustomerLoginVo getCustomerInfo(Long customerId);

    Boolean updateWxPhoneNumber(@RequestBody UpdateWxPhoneForm updateWxPhoneForm);
}
