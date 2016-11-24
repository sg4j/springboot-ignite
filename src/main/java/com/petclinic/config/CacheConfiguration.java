package com.petclinic.config;

import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheManager;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

/*    @Bean
    public DynamicClassLoaderWrapper dynamicClassLoaderWrapper() {
        return new DynamicClassLoaderWrapper(this.getClass().getClassLoader());
    }*/

    @Bean
    @SuppressWarnings("unchecked")
    public org.apache.ignite.cache.spring.SpringCacheManager cacheManager() {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        igniteConfiguration.setGridName("petclinic-ignite-grid");
        //igniteConfiguration.setClassLoader(dynamicClassLoaderWrapper());

        igniteConfiguration.setCacheConfiguration(this.createDefaultCache("petclinic"),
                this.createDefaultCache("org.hibernate.cache.spi.UpdateTimestampsCache"),
                this.createDefaultCache("org.hibernate.cache.internal.StandardQueryCache"));

        SpringCacheManager springCacheManager = new SpringCacheManager();
        springCacheManager.setConfiguration(igniteConfiguration);
        springCacheManager.setDynamicCacheConfiguration(this.createDefaultCache(null));
        return springCacheManager;
    }

    private org.apache.ignite.configuration.CacheConfiguration createDefaultCache(String name) {
        
    	org.apache.ignite.configuration.CacheConfiguration cacheConfiguration = new org.apache.ignite.configuration.CacheConfiguration();
        cacheConfiguration.setName(name);
        cacheConfiguration.setCacheMode(CacheMode.PARTITIONED);
        cacheConfiguration.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        cacheConfiguration.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
        cacheConfiguration.setStatisticsEnabled(true);
        cacheConfiguration.setEvictSynchronized(true);
        return cacheConfiguration;
    }
}