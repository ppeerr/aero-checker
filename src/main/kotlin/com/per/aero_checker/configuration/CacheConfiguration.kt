package com.per.aero_checker.configuration

import com.google.common.cache.CacheBuilder
import org.springframework.cache.Cache
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.guava.GuavaCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@EnableCaching
@Configuration
open class CacheConfiguration {

    @Bean
    open fun cacheOne(): Cache? {
        return GuavaCache(CACHE_ONE, CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build())
    }

    @Bean
    open fun cacheTwo(): Cache? {
        return GuavaCache(CACHE_TWO, CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build())
    }

    companion object {
        const val CACHE_ONE = "pulkovoDeparturesCache"
        const val CACHE_TWO = "pulkovoArrivalsCache"
    }
}