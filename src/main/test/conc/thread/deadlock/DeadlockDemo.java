package conc.thread.deadlock;

public class DeadlockDemo
{
    public static void main(String[] args)
    {
        Car car = new Car();
        License license = new License();

        Task_1 task1 = new Task_1(car, license);
        Task_2 task2 = new Task_2(car, license);

        Thread x = new Thread(task1, "X");
        Thread y = new Thread(task2, "Y");

        x.start();
        y.start();
    }
}
