import java.util.function.Supplier;

public class SupplierWithClass
{

    static <T> T use(Supplier<T> obj)
    {
        T o = obj.get();
        return o;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!" + use(() -> new Person()));
        System.out.println("Hello World!" + use(() -> new Employee2()));
    }
}

class Person {
    String id = "po";

    @Override
    public String toString()
    {
        return "Person{" +
                "id='" + id + '\'' +
                '}';
    }
}

class Employee2
{
    String name = "Emp";

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
