package com.atguigu.daijia.driver.service;

import com.atguigu.daijia.model.entity.driver.DriverInfo;
import com.atguigu.daijia.model.entity.driver.DriverSet;
import com.atguigu.daijia.model.form.driver.DriverFaceModelForm;
import com.atguigu.daijia.model.form.driver.UpdateDriverAuthInfoForm;
import com.atguigu.daijia.model.vo.driver.DriverAuthInfoVo;
import com.atguigu.daijia.model.vo.driver.DriverInfoVo;
import com.atguigu.daijia.model.vo.driver.DriverLoginVo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface DriverInfoService extends IService<DriverInfo> {


    Long login(String code);


    //获取司机信息
    DriverLoginVo getDriverInfo(Long driverId);

    //获取司机认证信息
    DriverAuthInfoVo getDriverAuthInfo(Long driverId);
    //更新司机认证信息
    Boolean updateDriverAuthInfo(UpdateDriverAuthInfoForm updateDriverAuthInfoForm);

    //创建司机人脸模型
    Boolean creatDriverFaceModel(DriverFaceModelForm driverFaceModelForm);

    DriverSet getDriverSet(Long driverId);

    Boolean isFaceRecognition(Long driverId);

    Boolean verifyDriverFace(DriverFaceModelForm driverFaceModelForm);

    Boolean updateServiceStatus(Long driverId, Integer status);

    DriverInfoVo getDriverInfoOrder(Long driverId);

    String getDriverOpenId(Long driverId);
}
