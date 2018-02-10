import java.util.ArrayList;
import java.util.List;

public class ConCurrentModTest
{

    public static void main(String[] args) throws InterruptedException
    {
        List<String> list = new ArrayList<>();


        Thread t1 = new Thread(() -> {
            String data = "data";
            for (int i = 20; i < 30; i++)
            {
                try
                {
                    list.add(data + i);
                    System.out.println(i);
                    Thread.sleep(1);
                }
                catch (Exception e)
                {
                    System.out.println("Thread 1 list size " + list.size());
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            String data = "data";
            for (int i = 80; i < 90; i++)
            {
                try
                {
                    list.add(data + i);
                    System.out.println(i);
                    Thread.sleep(1);
                }
                catch (Exception e)
                {
                    System.out.println("Thread 2 list size " + list.size());
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        /*
            Two threads add the data in the same list most of the times
            data is wrong even though thread join using and
            some cases ArrayIndexOutOfBoundsException will thrown.

        */

        System.out.println("list " + list.size());
        System.out.println("list " + list);
    }
}
