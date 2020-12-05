package com.notejava.cache;

import com.notejava.constant.CacheName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * CaffeineCache实现类
 * </p>
 *
 * @author lyle
 * @since 2020-06-30
 */
@Slf4j
@Service("caffeineCache")
public class CaffeineCache implements Cache {
    @Autowired
    private CacheManager caffeineCacheManager;


    @Override
    public <T> T get(CacheName cacheName, String key, Class<T> clazz) {
        log.debug("{} get -> cacheName [{}], key [{}], class type [{}]", this.getClass().getName(), cacheName, key, clazz.getName());
        return Objects.requireNonNull(caffeineCacheManager.getCache(cacheName.getCacheName())).get(key, clazz);
    }

    @Override
    public void put(CacheName cacheName, String key, Object value) {
        log.debug("{} put -> cacheName [{}], key [{}], value [{}]", this.getClass().getName(), cacheName, key, value);
        Objects.requireNonNull(caffeineCacheManager.getCache(cacheName.getCacheName())).put(key, value);
    }

    @Override
    public void remove(CacheName cacheName, String key) {
        log.debug("{} remove -> cacheName [{}], key [{}]", this.getClass().getName(), cacheName, key);
        Objects.requireNonNull(caffeineCacheManager.getCache(cacheName.getCacheName())).evict(key);
    }
}
