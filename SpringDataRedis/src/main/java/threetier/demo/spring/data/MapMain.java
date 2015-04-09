package threetier.demo.spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import threetier.demo.spring.data.config.ApplicationConfig;
import threetier.demo.spring.data.domain.User;
import threetier.demo.spring.data.service.RedisSpringDataService;

public class MapMain {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		boolean useJavaConfig = true;
		ApplicationContext context = null;

		if (useJavaConfig) {
			context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		} else {
			context = new ClassPathXmlApplicationContext("springapp.xml");
		}

		
		@SuppressWarnings("unchecked")
		RedisSpringDataService<User> userMapService = (RedisSpringDataService<User>) context.getBean("userMapService");
		User user1 = new User("user1ID", "User 1");
		User user2 = new User("user2ID", "User 2");
		System.out.println("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: " + userMapService.get(user1));
		System.out.println("User is not in redis yet: " + userMapService.get(user2));
		System.out.println("==== putting objects into redis ====");
		userMapService.put(user1);
		userMapService.put(user2);
		System.out.println("==== getting objects from redis ====");
		System.out.println("User should be in redis yet: " + userMapService.get(user1));
		System.out.println("User should be in redis yet: " + userMapService.get(user2));
		System.out.println("==== deleting objects from redis ====");
		userMapService.delete(user1);
		userMapService.delete(user2);
		System.out.println("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: " + userMapService.get(user1));
		System.out.println("User is not in redis yet: " + userMapService.get(user2));
	}
}
