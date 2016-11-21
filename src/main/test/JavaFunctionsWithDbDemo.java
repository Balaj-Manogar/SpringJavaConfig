import org.baali.dto.Employee;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Balaji on 19/11/16.
 */
public class JavaFunctionsWithDbDemo<T> implements IGeneric<T>
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException
    {
        Timestamp date = new Timestamp(new Date().getTime());
//        EmployeeService service = new EmployeeService();
        //System.out.println(service.searchEmployees());

        JavaFunctionsWithDbDemo demo = new JavaFunctionsWithDbDemo();
        Supplier<List<Employee>> employees = () -> new ArrayList<>();
        Function<Employee, String> sqlFunction = employee ->
        {
            System.out.println("Employee: " + employee);
            return "SELECT * from employees";
        };

        Supplier<Employee> inputObject = () ->
        {
            Employee e = new Employee();
            e.setEmployeeId(123);
            e.setEmployeeName("Balaji");
            return e;
        };

        //demo.testList(new Employee());
        //demo.testSupplier(() -> new Department());
        demo.usingClass(Employee.class);
        demo.functionWithSupplier(sqlFunction, inputObject);
    }

    @Override
    public void create() throws IllegalAccessException,
            InstantiationException
    {
        Class<T> persistentClass = (Class<T>)
                ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        System.out.println(persistentClass);

    }

    public void testList(Employee e)
    {
        List<Employee> es = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {

            e = new Employee();
            e.setEmployeeId(i);
            es.add(e);
        }

        es.forEach(System.out::println);
    }

    public void testSupplier(Supplier<T> supplier) throws IllegalAccessException, InstantiationException
    {
        T obj = supplier.get();
        T obj2 = (T) obj.getClass().newInstance();
        System.out.println(obj2.getClass().getTypeName());
    }

    public void checkClazz(Class<T> clazz) throws IllegalAccessException, InstantiationException
    {
        Class<T> theClass = (Class<T>) clazz.newInstance();
        System.out.println(theClass.getTypeName());
    }

    public T methodReflection() throws NoSuchMethodException
    {
        Method m = JavaFunctionsWithDbDemo.class.getDeclaredMethod("methodReflection", null);
        Type returnType = m.getGenericReturnType();
        if (returnType instanceof ParameterizedType)
        {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments)
            {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
        return null;

    }

    public <T> void usingClass(Class<?> clazz) throws IllegalAccessException, InstantiationException
    {
        Class<?> theClazz = clazz;
        Employee e = (Employee) theClazz.newInstance();


        System.out.println(theClazz.getTypeName() + " Class: " + e);
    }


    public <T> void functionWithSupplier(Function<T, String> sqlFunction, Supplier<T> inputObject)
    {
        T obj = inputObject.get();
        if (!ObjectUtils.isEmpty((obj)))
        {
            String sql = sqlFunction.apply(obj);
            System.out.println("SQL: " + sql);
        }
        else
        {
            System.out.println("functionWithSupplier: Object is empty");
        }
    }


}
