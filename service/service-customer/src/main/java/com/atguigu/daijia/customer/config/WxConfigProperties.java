package com.atguigu.daijia.customer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component("customerWxConfigProperties")
@ConfigurationProperties(prefix = "wx.miniapp")

public class WxConfigProperties {
    private String appId;
    private String secret;
}
