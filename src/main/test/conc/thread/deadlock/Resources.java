package conc.thread.deadlock;

class Car
{
    public void purchase()
    {
        System.out.println("Car is driving by " + Thread.currentThread().getName());
    }
}

class License {
    public void apply()
    {
        System.out.println("License applied by " + Thread.currentThread().getName());
    }
}
