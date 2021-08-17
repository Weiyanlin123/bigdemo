package com.citycloud.dcm.street.config;

import com.citycloud.dcm.street.config.guava.GuavaCache;
import com.citycloud.dcm.street.param.Sourceip;
import com.google.common.cache.CacheLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuavaConfig {
    @Bean
    public GuavaCache getGuavaCache(){
        GuavaCache guavaCache  = new GuavaCache();
        CacheLoader<String, Sourceip> loader1 = new CacheLoader<String, Sourceip>() {
            @Override
            public Sourceip load(String key) throws Exception {
                // 调用dubbo接口获取Sourceip
                return GuavaCache.getSourceip(key);
            }
        };
        guavaCache.setLoader("sourceip", loader1, 20000, 100, 100);
        return guavaCache;
    }


}
