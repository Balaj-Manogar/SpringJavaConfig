package conc.thread.signal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * This program is simple demonstration of wait and
 * notify using CountDownLatch. Consumer will wait
 * till the lock becomes zero. Disadvantage is we cannot
 * reuse this latch.
 */
class ProducerConsumerWaitAndNotifyUsingLatch
{
    private List<String> jobs = new ArrayList<>();
    private CountDownLatch latch;

    ProducerConsumerWaitAndNotifyUsingLatch(CountDownLatch latch)
    {
        this.latch = latch;
    }

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Program Started...");
        CountDownLatch latch = new CountDownLatch(3);
        ProducerConsumerWaitAndNotifyUsingLatch producerConsumer = new ProducerConsumerWaitAndNotifyUsingLatch(latch);

        Runnable producerRunnable = () -> {
            System.out.println("Producer thread started..");
            try
            {
                Thread.sleep(5000);
                producerConsumer.produce();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        };
        Thread producer1 = new Thread(producerRunnable, "Producer1");
        Thread producer2 = new Thread(producerRunnable, "Producer2");
        Thread producer3 = new Thread(producerRunnable, "Producer3");

        Thread consumer = new Thread(() -> {
            System.out.println("Consumer Thread started..");
            try
            {
                producerConsumer.consume();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "Consumer");

        producer1.start();
        producer2.start();
        producer3.start();
        consumer.start();

        producer1.join();
        producer2.join();
        producer3.join();
        consumer.join();

    }

    public void produce() throws InterruptedException
    {
        Random random = new Random();


        synchronized (this)
        {
            latch.countDown();
            System.out.println("Pro Job size: " + jobs.size());

            String job = "Job " + random.nextInt(100);
            jobs.add(job);
            System.out.println("Added Job: " + job);
            Thread.sleep(1000);


        }

    }

    public void consume() throws InterruptedException
    {
        latch.await();
        synchronized (this)
        {
            System.out.println("Cons Job size: " + jobs.size());

            String removedJob = jobs.remove(0);
            System.out.println("Removed Job: " + removedJob);
            //Thread.sleep(1000);

        }
    }
}
