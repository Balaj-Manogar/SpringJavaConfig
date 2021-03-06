package conc.thread.deadlock;

public class DeadlockDemo
{
    public static void main(String[] args)
    {
        Key key = new Key();
        Car car = new Car();

        Task_1 task1 = new Task_1(key, car);
        Task_2 task2 = new Task_2(key, car);

        Thread x = new Thread(task1, "X");
        Thread y = new Thread(task2, "Y");

        x.start();
        y.start();
    }
}
