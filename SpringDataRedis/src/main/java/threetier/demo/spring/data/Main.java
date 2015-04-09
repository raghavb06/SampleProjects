package threetier.demo.spring.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import threetier.demo.spring.data.config.ApplicationConfig;
import threetier.demo.spring.data.domain.User;
import threetier.demo.spring.data.service.RedisSpringDataService;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {

		boolean useJavaConfig = true;
		ApplicationContext context = null;

		if (useJavaConfig) {
			context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		} else {
			context = new ClassPathXmlApplicationContext("springapp.xml");
		}

		RedisSpringDataService<User> userService = (RedisSpringDataService<User>) context.getBean("userService");

		User user1 = new User("USer1", "ID-1");
		User user2 = new User("USer1", "ID-2");

		System.out.println("-------- getting objects from redis --------");
		logger.info("User is not in redis yet {}", userService.get(user1));
		logger.info("User is not in redis yet {}", userService.get(user2));

		System.out.println("-------- putting objects into redis --------");
		userService.put(user1);
		userService.put(user2);
		System.out.println("-------- getting objects from redis --------");
		logger.info("User should be in redis {}", userService.get(user1));
		logger.info("User should be in redis {}", userService.get(user2));

		System.out.println("-------- deleting objects from redis --------");
		userService.delete(user1);
		userService.delete(user2);
		System.out.println("-------- getting objects from redis --------");
		logger.info("User is not in redis yet {}", userService.get(user1));
		logger.info("User is not in redis yet {}", userService.get(user2));

	}

}
