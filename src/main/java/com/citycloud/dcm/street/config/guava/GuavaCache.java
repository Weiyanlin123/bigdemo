/*********************************************
 *slz
 *********************************************/
package com.citycloud.dcm.street.config.guava;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.citycloud.dcm.street.param.Source;
import com.citycloud.dcm.street.param.Sourceip;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;

import javax.annotation.PostConstruct;

/**
 * 过期时间优先级以他们两个最小的值为准
 */

//@Component
public class GuavaCache {

    private long defaultMaximumSize = 20000;// max store size.
    private long defaultAccessDuration = 180;// 对象多久没有被访问后过期
    private long defaultWriteDuration = 300;// 写入到缓存后多久过期
    private boolean isRecordStats = false;// 开启统计信息开关 true|on, false|off

    private Map<String, LoadingCache<Object, Object>> cacheMap = new HashMap<String, LoadingCache<Object, Object>>();

    @SuppressWarnings("unchecked")
    public <K, V> void setLoader(String cacheName, CacheLoader<K, V> loader, long maximumSize, long accessDuration,
                                 long writeDuration) {
        if (loader == null) {
            return;
        }
        long newMaximumSize = (maximumSize == 0 ? this.defaultMaximumSize : maximumSize);
        long newAccessDuration = (accessDuration == 0 ? defaultAccessDuration : accessDuration);
        long newWriteDuration = (writeDuration == 0 ? defaultWriteDuration : writeDuration);

        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
        builder = builder.maximumSize(newMaximumSize).expireAfterAccess(newAccessDuration, TimeUnit.SECONDS)
                .expireAfterWrite(newWriteDuration, TimeUnit.SECONDS);

        if (isRecordStats) {
            builder.recordStats();
        }
        LoadingCache<K, V> cacheService = builder.build(loader);

        cacheMap.put(cacheName, (LoadingCache<Object, Object>) cacheService);

    }

    /**
     * 是否生成统计信息
     *
     * @param isRecordStats 是否生成统计数据，默认为false
     */
    public void setRecordStatsFlag(boolean isRecordStats) {
        this.isRecordStats = isRecordStats;
    }

    /**
     * 获取统计信息
     *
     * @param cacheName 缓存名
     * @return
     */
    @SuppressWarnings("unchecked")
    public <K, V> CacheStats getStats(String cacheName) {
        LoadingCache<K, V> cacheService = (LoadingCache<K, V>) cacheMap.get(cacheName);
        if (cacheService == null) {
            return null;

        }
        return cacheService.stats();
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    public <K, V> V get(String cacheName, K key) {
        LoadingCache<K, V> cacheService = (LoadingCache<K, V>) cacheMap.get(cacheName);
        if (cacheService == null) {
            return null;

        }
        try {
            return cacheService.get(key);
        } catch (Throwable e) {
            return null;
        }
    }

    public static Sourceip getSourceip(String sourceid) {
        // 调用dubbo接口获取Sourceip
        if ("100000".equals(sourceid)) {
            Sourceip s = new Sourceip();
            s.setIp("127.0.0.1/32");
            s.setSourceid("100000");
            s.setAllow("000");
            s.setType("10");
            return s;
        } else if ("100001".equals(sourceid)) {
            Sourceip s = new Sourceip();
            s.setIp("127.0.0.1/32");
            s.setSourceid("100001");
            s.setAllow("000");
            s.setType("10");
            return s;
        }
        return null;

    }

    public static Source getSourceInfo(String sourceid) {
        // 调用dubbo接口获取Sourceip
        if ("100000".equals(sourceid)) {
            Source s = new Source();
            s.setSourceid("100000");
            s.setKey("12345");
            return s;
        } else if ("100001".equals(sourceid)) {
            Source s = new Source();
            s.setSourceid("100001");
            s.setKey("11111");
            s.setName("测试");
            return s;
        }
        return null;

    }

    public static void main(String[] args) {
        GuavaCache guavaCache = new GuavaCache();
        guavaCache.setRecordStatsFlag(false);

        CacheLoader<String, Sourceip> loader1 = new CacheLoader<String, Sourceip>() {

            @Override
            public Sourceip load(String key) throws Exception {
                // 调用dubbo接口获取Sourceip
                return GuavaCache.getSourceip(key);
            }

        };
//
//	CacheLoader<String, Source> loader2 = new CacheLoader<String, Source>() {
//
//	    @Override
//	    public Source load(String key) throws Exception {
//		// 调用dubbo接口获取Source
//		return GuavaCache.getSourceInfo(key);
//	    }
//
//	};

        guavaCache.setLoader("sourceip", loader1, 20000, 100, 100);
//	guavaCache.setLoader("sourceinfo", loader2, 20000, 1, 1);

        Sourceip sourceip = guavaCache.get("sourceip", "100000");
        Sourceip sourceip2 = guavaCache.get("sourceip", "100000");
        Sourceip sourceip3 = guavaCache.get("sourceip", "100000");
        System.out.println(sourceip3);
        System.out.println(sourceip2);
        System.out.println(sourceip);
//	Source sourceinfo = guavaCache.get("sourceinfo", "100000");
//	System.out.println(sourceinfo);
//	sourceinfo = guavaCache.get("sourceinfo", "100001");
//	System.out.println(sourceinfo);
//	sourceinfo = guavaCache.get("sourceinfo", "100002");
//	System.out.println(sourceinfo);

    }

}
