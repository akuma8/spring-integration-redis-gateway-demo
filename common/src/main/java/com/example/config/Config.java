package com.example.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author Attoumane AHAMADI
 */
@Configuration
public class Config implements BeanClassLoaderAware {

	private ClassLoader classLoader;

	@Bean
	public RedisSerializer<?> redisSerializer() {
		return new JdkSerializationRedisSerializer(this.classLoader);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

}
