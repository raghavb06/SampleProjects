package threetier.demo.spring.data.service;

import threetier.demo.spring.data.domain.Cacheable;

public interface RedisSpringDataService<V extends Cacheable> {

	public void put(V object);

	public V get(V key);

	public void delete(V Key);
}
