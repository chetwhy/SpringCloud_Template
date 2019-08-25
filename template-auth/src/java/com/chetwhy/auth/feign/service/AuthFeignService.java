package com.chetwhy.auth.feign.service;

import com.chetwhy.auth.feign.service.fallback.AuthFeignServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/8/25 14:30
 * @Version 1.0
 */
@FeignClient(value = "template-admin",fallback = AuthFeignServiceFallbackImpl.class)
public interface AuthFeignService {

    /**
     * 这里暴露一个Feign接口地址，其中@GetMapping中的地址一定对应了template-admin服务中某个Controller中的请求地址（如果template-admin服务中没有这个接口地址就会404）
     * 如果其他地方调用了AuthFeignService接口的hello方法，FeignClient将类似通过转发的方式去请求调用`template-admin`服务中符合的接口地址的方法
     * 如果请求传递了参数，需要加@RequestParam注解标识。如果URL中有动态参数，要添加@PathVariable注解
     *
     * @param name
     * @return
     */
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name") String name);
}
