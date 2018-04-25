package conc.thread.deadlock;

class Task_1 implements Runnable
{
    private Car car;
    private License license;

    public Task_1(Car car, License license)
    {
        this.car = car;
        this.license = license;
    }



    @Override
    public void run()
    {
        System.out.println("Task_1 will acquire its resources now");
        synchronized (car)
        {
            sleep();
            synchronized (license)
            {
                car.purchase();
                license.apply();
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
    private Car car;
    private License license;

    public Task_2(Car car, License license)
    {
        this.car = car;
        this.license = license;
    }



    @Override
    public void run()
    {
        System.out.println("Task_2 will acquire its resources now");
        synchronized (license)
        {
            sleep();
            synchronized (car)
            {
                license.apply();
                car.purchase();
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
