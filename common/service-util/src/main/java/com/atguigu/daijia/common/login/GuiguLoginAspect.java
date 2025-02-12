package com.atguigu.daijia.common.login;

import com.atguigu.daijia.common.constant.RedisConstant;
import com.atguigu.daijia.common.execption.GuiguException;
import com.atguigu.daijia.common.result.ResultCodeEnum;
import com.atguigu.daijia.common.util.AuthContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect

public class GuiguLoginAspect {
    @Autowired
    private RedisTemplate redisTemplate;
    //环绕通知
    //切入点表达式：指定对某些方法增强
    @Around("execution(* com.atguigu.daijia.*.controller.*.*(..)) && @annotation(guiguLogin)")
   public Object login(ProceedingJoinPoint proceedingJoinPoint,GuiguLogin guiguLogin)  throws Throwable {

        //获取request对象
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) attributes;
        HttpServletRequest request = sra.getRequest();

        //从请求头获取token
        String token = request.getHeader("token");
        //判断token是否为空
        if (!StringUtils.hasText(token)){
            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
        }
        //token不为空，查询redis
        String customerId = (String) redisTemplate
                             .opsForValue()
                             .get(RedisConstant.USER_LOGIN_KEY_PREFIX + token);
        //查询redis对应用户id，把用户id放到TreadLocal里面
        if (StringUtils.hasText(customerId)){
            AuthContextHolder.setUserId(Long.parseLong(customerId));
        }
        //执行业务方法
        return proceedingJoinPoint.proceed();
    }
}
