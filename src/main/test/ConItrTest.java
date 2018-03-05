import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConItrTest
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();

        list.add("One");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
        {
            list.add("T1");
            iterator.next();
        }
        Thread t1 =  new Thread(() -> {
            while (iterator.hasNext())
            {
                list.add("T1");
                iterator.next();
            }
        });

        System.out.println("list " + list);

    }
}
