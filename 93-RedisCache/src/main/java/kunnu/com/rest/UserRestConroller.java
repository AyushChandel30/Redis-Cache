package kunnu.com.rest;

import java.util.List;
import kunnu.com.binding.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestConroller {
    
    private HashOperations <String, Integer, User> hashOps;

    public UserRestConroller(RedisTemplate<String, User> redisTemplate) {
        hashOps = redisTemplate.opsForHash();
    }
    
    @PostMapping ("/store")
    public String storeData (@RequestBody User user){
        hashOps.put("PERSONS", user.getId(), user);
        return "success";
    }
    
    @GetMapping ("/user/{id}")
    public User getData (@PathVariable ("id") Integer id){
        User value = (User) hashOps.get("PERSONS", id);
        return value;
    }
    
    @GetMapping ("/users")
    public List <User> getAllUsers(){
        return  hashOps.values("PERSONS");
    }
    
    @DeleteMapping ("/user/{id}")
    public String deleteOne (@PathVariable ("id") Integer id) {
        hashOps.delete("PERSONS", id);
        return "Record deleted";
    }
}
