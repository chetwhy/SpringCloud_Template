package com.chetwhy.auth.feign.service.fallback;

import org.springframework.stereotype.Component;

import com.chetwhy.auth.feign.service.AuthFeignService;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/8/25 14:45
 * @Version 1.0
 */
@Component
public class AuthFeignServiceFallbackImpl implements AuthFeignService {

    @Override
    public String hello(String name) {
        return "hello " + name + ", this is template-auth, but request error";
    }
}
