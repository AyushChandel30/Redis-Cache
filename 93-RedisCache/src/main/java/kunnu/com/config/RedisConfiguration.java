package kunnu.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {
	
            @Bean
            public JedisConnectionFactory jedisConnectionFactory () {
            JedisConnectionFactory jcf = new JedisConnectionFactory();
            jcf.setHostName("Student");
            jcf.setPassword("Musaddil@l3108");
            jcf.setPort(0); 
            return jcf;
	}
//all these will be provied by company
//if redis server is running in your computer, then no need for these configurations. 
	
	@Bean
                     @Primary
	public RedisTemplate<String, String> redisTemplate (JedisConnectionFactory jcf){
		RedisTemplate<String, String> rt = new RedisTemplate<>();
		rt.setConnectionFactory(jcf);
		return rt;
	}
        
        
	
}
