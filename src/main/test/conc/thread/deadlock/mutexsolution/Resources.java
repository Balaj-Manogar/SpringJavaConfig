package conc.thread.deadlock.mutexsolution;

class Key
{
    public void pick()
    {
        System.out.println("Key is driving by " + Thread.currentThread().getName());
    }
}

class Car
{
    public void drive()
    {
        System.out.println("Car applied by " + Thread.currentThread().getName());
    }
}
