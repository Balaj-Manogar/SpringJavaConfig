import java.util.ArrayList;
import java.util.List;

/**
 * Created by Balaji on 15/02/17.
 */
public class CollectionStreamDemo
{
    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<Employee>()
        {{
            add(new Employee("Balaji", "1"));
            add(new Employee("Boopathi", "2"));
            add(new Employee("Malar", "3"));
            add(new Employee("Manogar", "4"));
            add(new Employee("Monika", "5"));
            add(new Employee("Anu Sandhya", "6"));
        }};

        System.out.println("Employees: " + employees);

        System.out.println();

        System.out.println(
        employees.stream()
                .map(employee -> employee.getName())
                .anyMatch(name -> {
                    return name.toLowerCase().contains("alo");
                })
        );
    }
}

class Employee
{
    private String name;
    private String id;

    public Employee(String name, String id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
