package threetier.demo.spring.data.domain;

public class User implements Cacheable {

	private static final long serialVersionUID = -6661709054031285696L;

	public static final String OBJECT_KEY = "USER";

	private String name;
	private String id;

	public User() {
	}

	public User(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getKey() {
		return getId();
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
