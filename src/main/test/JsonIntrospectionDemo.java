import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

import org.baali.dto.Employee;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JsonIntrospectionDemo
{

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        ObjectMapper mapper = new ObjectMapper();
        JavaType userType = mapper.getTypeFactory().constructType(Employee.class);
        BeanDescription introspection = mapper.getSerializationConfig().introspect(userType);
        List<BeanPropertyDefinition> properties = introspection.findProperties();
        properties.forEach((b) -> System.out.println(b));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        properties.forEach((b) -> System.out.println("Annotated Field: " + b.getField().getName()
                + " Annotated Name: " + b.getFullName().getSimpleName()
                + " Setter name: " + b.getSetter().getName()
                + " TYPE: " + b.getField().getRawType()
                + " Parameter Type: " + b.getSetter().getParameter(0).getRawType()
                + " Setter Parameter Type: " + b.getSetter().getParameter(0).getRawType()
        ));

        org.baali.dto.Employee e = new org.baali.dto.Employee();

        //Method method = e.getClass().getMethod("setId", int.class);

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

        String sql = "select * from Employee";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Employee> employeeList = new ArrayList<>();
        while (rs.next())
        {
            ObjectMapper mapper2 = new ObjectMapper();
            JavaType userType2 = mapper.getTypeFactory().constructType(e.getClass());
            BeanDescription introspection2 = mapper2.getSerializationConfig().introspect(userType2);
            List<BeanPropertyDefinition> properties2 = introspection.findProperties();
            org.baali.dto.Employee empObjMain = null;
            org.baali.dto.Employee empObj = null;
            try
            {
                empObj = e.getClass().newInstance();
            }
            catch (InstantiationException e1)
            {
                e1.printStackTrace();
            }
            catch (IllegalAccessException e1)
            {
                e1.printStackTrace();
            }
           for(BeanPropertyDefinition b: properties2)
            {

                System.out.println("Field: " + b.getField().getName());


                System.out.println("Method Name: " + b.getSetter().getName() + " Param: " + b.getSetter().getParameter(0)
                        .getRawType());
                try
                {
                    Method m = empObj.getClass().getMethod(b.getSetter().getName(), b.getSetter().getParameter(0).getRawType());
                    Object object = rs.getObject(b.getFullName().getSimpleName());
                    //System.out.println("Field: " + b.getField().getName() + " Type: " + b.getSetter().getParameter(0)
                    //    .getRawType().cast(object));
                   // m.invoke(empObj, b.getSetter().getParameter(0).getRawType().cast(object));
                    getResultSetField(rs, b.getSetter().getParameter(0).getRawType().getName());

                }
                catch (NoSuchMethodException e1)
                {
                    e1.printStackTrace();
                }



                //m.invoke(empObj, getResultSetField())



            }
            //empObjMain = empObj;
            System.out.println("Invoked Employee instance: " + empObjMain);
        }

        //System.out.println(method);
    }

    private static <T> void getResultSetField(ResultSet rs, T typeName) throws SQLException
    {
        System.out.println("getResultSetField: " + typeName + "  :::: " + rs.getTimestamp("joinedDate"));
    }


}

/*class Employee{
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
	
	
}*/
