
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

import java.lang.reflect.Method;
import java.util.List;

public class JsonIntrospectionDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		ObjectMapper mapper = new ObjectMapper();
		JavaType userType = mapper.getTypeFactory().constructType(Employee.class);
		BeanDescription introspection = mapper.getSerializationConfig().introspect(userType);
		List<BeanPropertyDefinition> properties = introspection.findProperties();
		properties.forEach((b) -> System.out.println(b ));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		properties.forEach((b) -> System.out.println("Annotated Field: " + b.getField().getName()
                + " Annotated Name: " + b.getFullName().getSimpleName()
				+ " Setter name: " + b.getSetter().getName()
                + " TYPE: "+ b.getField().getRawType()
                + " Parameter Type: " + b.getSetter().getParameter(0).getRawType()
				+ " Setter Parameter Type: " + b.getSetter().getParameter(0).getRawType()
		));

		Employee e = new Employee();
		
		Method method = e.getClass().getMethod("setId", int.class);
		
		//System.out.println(method);
	}

}

class Employee{
	private int id;
	@JsonProperty("desc")
	private String description;

	private transient String  inValidFied;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
