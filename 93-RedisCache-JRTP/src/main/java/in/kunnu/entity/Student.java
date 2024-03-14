package in.kunnu.entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash ("studentHash")//studentHash is the key
public class Student {

	private Integer id;
	private String name;
	
}
