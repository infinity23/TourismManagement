package redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig{
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(20);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);
        return config;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.setPoolConfig(jedisPoolConfig);
        return factory;
    }

//    @Bean
//    public RedisCacheTransfer redisCacheTransfer(JedisConnectionFactory jedisConnectionFactory){
//        RedisCacheTransfer redisCacheTransfer = new RedisCacheTransfer();
//        redisCacheTransfer.setJedisConnectionFactory(jedisConnectionFactory);
//        return redisCacheTransfer;
//    }

}
