package conc.thread.deadlock.mutexsolution;

class Task_1 implements Runnable
{
    private Key key;
    private Car car;

    private Object mutex;

    public Task_1(Key key, Car car, Object theMutex)
    {
        this.key = key;
        this.car = car;
        this.mutex = theMutex;
    }


    @Override
    public void run()
    {
        System.out.println("Task_1 will acquire its resources now");
        synchronized (mutex)
        {
            key.pick();
            car.drive();
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

    private Object mutex;

    public Task_2(Key key, Car car, Object theMutex)
    {
        this.key = key;
        this.car = car;
        this.mutex = theMutex;
    }


    @Override
    public void run()
    {
        System.out.println("Task_2 will acquire its resources now");
        synchronized (mutex)
        {
            car.drive();
            key.pick();
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
