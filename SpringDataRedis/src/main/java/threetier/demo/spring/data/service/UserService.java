package threetier.demo.spring.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import threetier.demo.spring.data.domain.Cacheable;
import threetier.demo.spring.data.domain.User;

@Service("userService")
public class UserService implements RedisSpringDataService<User> {

	@Autowired
	RedisTemplate<String, Cacheable> redisTemplate;

	@Override
	public void put(User user) {
		redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
	}

	@Override
	public User get(User key) {
		return (User) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
	}

	@Override
	public void delete(User key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());

	}
}
