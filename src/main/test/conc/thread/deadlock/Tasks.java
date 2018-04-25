package conc.thread.deadlock;

class Task_1 implements Runnable
{
    private Key key;
    private Car car;

    public Task_1(Key key, Car car)
    {
        this.key = key;
        this.car = car;
    }



    @Override
    public void run()
    {
        System.out.println("Task_1 will acquire its resources now");
        synchronized (key)
        {
            sleep();
            synchronized (car)
            {
                key.pick();
                car.drive();
            }
        }
    }

    private void sleep()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
    }
}


class Task_2 implements Runnable
{
    private Key key;
    private Car car;

    public Task_2(Key key, Car car)
    {
        this.key = key;
        this.car = car;
    }



    @Override
    public void run()
    {
        System.out.println("Task_2 will acquire its resources now");
        synchronized (car)
        {
            sleep();
            synchronized (key)
            {
                key.pick();
                car.drive();
            }
        }
    }

    private void sleep()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
    }
}
