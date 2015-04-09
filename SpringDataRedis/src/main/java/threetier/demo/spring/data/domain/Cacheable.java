package threetier.demo.spring.data.domain;

import java.io.Serializable;

public interface Cacheable extends Serializable {

	public String getKey();

	public String getObjectKey();

}
