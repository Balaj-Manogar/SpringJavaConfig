package conc.thread;

import java.util.concurrent.TimeUnit;

public class InterruptedDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        Bartender bartender = new Bartender();
        Thread bartenderThread = new Thread(bartender, "Bartender");

        bartenderThread.start();

        // Not very robust, but should allow the Bartender to get to sleep first
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            // This can be ignored
        }

        int numCustomers = 12;

        for (int i=1; i<=numCustomers; i++) {
            String customerName = "Customer " + i;
            Customer customer = new Customer(bartenderThread, customerName, (int) (Math.random() * 10), bartender);

            Thread t = new Thread(customer, customerName);
            t.start();
            //t.join();
        }

        System.out.println("Main exit...");
    }
}

class Bartender implements Runnable
{
    public synchronized  void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    volatile String customerName = "";
    public void run()
    {
        System.out.println("Bartender: My boss isn't in today; time for a quick snooze!");

        while (true) {
            System.out.println("is interrupted: " + Thread.currentThread().isInterrupted());
            boolean interrupted = Thread.interrupted();
            System.out.println("interrupted: " + interrupted);
            if (interrupted) {
                System.out.println("Bartender: Zzz, I need to serve this  " + customerName  + ".  " + Thread.currentThread
                        ().isInterrupted() );
            }
//
            try
            {
                System.out.println("Bartender is working...");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("I served to " + customerName + ", Bartender is sleeping....");
            }
            catch (InterruptedException e)
            {
                System.out.println("While Serving another customer,  " + customerName + " is interrupted me..." );
                Thread.currentThread().interrupt();
                //Thread.interrupted();
                //throw new RuntimeException() ;

            }
        }
    }
}

class Customer implements Runnable
{
    private Thread bartenderThread;
    private String name;
    private int waitTime;
    private Bartender bartender;

    public Customer(Thread bartenderThread, String name, int waitTime, Bartender bartender)
    {
        this.bartenderThread = bartenderThread;
        this.name = name;
        this.waitTime = waitTime;
        this.bartender = bartender;
    }

    public void run()
    {
        System.out.println(name + ": Doesn't seem to be anyone around. I'll wait for "+ waitTime +" seconds.");

        try
        {
            TimeUnit.SECONDS.sleep(waitTime);
        }
        catch (InterruptedException e)
        {
            System.out.println(name + " is interrupted");
        }

        System.out.println(name + ": Oh there's a bell! Can I get some service around here?");
        synchronized (bartender)
        {

            bartender.setCustomerName(name);
            bartenderThread.interrupt();
        }
    }
}

