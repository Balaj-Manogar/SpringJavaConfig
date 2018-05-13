package conc.thread.signal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ProducerConsumerPoorImplementation
{
    private List<String> jobs = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Program Started...");
        ProducerConsumerPoorImplementation producerConsumer = new ProducerConsumerPoorImplementation();

        Thread producer = new Thread(() -> {
            System.out.println("Producer thread started..");
            try
            {
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
                Thread.sleep(1000);
                if (jobs.size() < 10)
                {
                    String job = "Job " + random.nextInt(100);
                    jobs.add(job);
                    System.out.println("Added Job: " + job);
                } else {
                    System.out.println("Waiting job...");
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
                Thread.sleep(1000);
                System.out.println("After sleep");
                if (jobs.size() > 0)
                {
                    String removedJob = jobs.remove(0);
                    System.out.println("Removed Job: " + removedJob);
                }
            }
        }
    }
}
