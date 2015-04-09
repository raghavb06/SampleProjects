package threetier.demo.spring.data.service;

import org.springframework.data.redis.support.collections.DefaultRedisMap;
import org.springframework.stereotype.Service;

import threetier.demo.spring.data.domain.Cacheable;
import threetier.demo.spring.data.domain.User;

@Service("userMapService")
public class UserMapService implements RedisSpringDataService<User> {

	// @Autowired
	DefaultRedisMap<String, Cacheable> userRedisMap;

	@Override
	public void put(User user) {
		userRedisMap.put(user.getKey(), user);
	}

	@Override
	public void delete(User key) {
		userRedisMap.remove(key.getKey());
	}

	@Override
	public User get(User key) {
		return (User) userRedisMap.get(key.getKey());
	}

	public void setUserRedisMap(DefaultRedisMap<String, Cacheable> userRedisMap) {
		this.userRedisMap = userRedisMap;
	}

}
