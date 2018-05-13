package conc.thread.signal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 *  This program  also improper way of synchronizing
 *  way of synchronizing threads. Both are synchronized
 *  their jobs, but consumer thread is started first
 *  then its notify is no use. Since it is in while loop
 *  we don't have any issue otherwise producer will never
 *  produce. We need to be very careful while signalling the threads.
 *
 *
 *
 */
class ProducerConsumerWaitAndNotify
{
    private List<String> jobs = new ArrayList<>();
    private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Program Started...");
        ProducerConsumerWaitAndNotify producerConsumer = new ProducerConsumerWaitAndNotify();

        Thread producer = new Thread(() -> {
            System.out.println("Producer thread started..");
            try
            {
                Thread.sleep(1000);
                producerConsumer.produce();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            System.out.println("Consumer thread started..");
            try
            {
                producerConsumer.consume();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }

    public void produce() throws InterruptedException
    {
        Random random = new Random();
        while (true)
        {
            synchronized (this)
            {
                System.out.println("Pro Job size: " + jobs.size());
                if (jobs.size() < 10)
                {
                    String job = "Job " + random.nextInt(100);
                    jobs.add(job);
                    System.out.println("Added Job: " + job);
                    Thread.sleep(1000);
                } else {
                    System.out.println("Notifying consumer...");
                    this.wait();
                }
            }
        }
    }

    public void consume() throws InterruptedException
    {
        while (true)
        {
            synchronized (this)
            {
                System.out.println("Cons Job size: " + jobs.size());
                if (jobs.size() > 0)
                {
                    String removedJob = jobs.remove(0);
                    System.out.println("Removed Job: " + removedJob);
                    Thread.sleep(1000);
                } else {
                    System.out.println("Notifying producer...");
                    this.notify();
                }
            }
        }
    }
}
