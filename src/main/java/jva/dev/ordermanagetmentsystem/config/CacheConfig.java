package jva.dev.ordermanagetmentsystem.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {


    public static final String OBJECT_INFO_CACHE = "OBJECT_INFO_CACHE";

    @Bean
    public CacheManager cacheManager(){

        List<CaffeineCache> caches = new ArrayList<>();
        caches.add(buildCache(OBJECT_INFO_CACHE,10,TimeUnit.HOURS,100));

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(caches);
        return manager;
    }


    public static CaffeineCache buildCache(String cacheName, int ttl, TimeUnit ttlUnit, int size) {
        return new CaffeineCache(cacheName, Caffeine.newBuilder()
                .expireAfterWrite(ttl,ttlUnit)
                .maximumSize(size)
                .build());
    }

}
