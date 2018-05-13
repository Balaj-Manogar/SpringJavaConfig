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
 *
 *
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
        CountDownLatch latch = new CountDownLatch(1);
        ProducerConsumerWaitAndNotifyUsingLatch producerConsumer = new ProducerConsumerWaitAndNotifyUsingLatch(latch);

        Thread producer = new Thread(() -> {
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

        latch.countDown();
        synchronized (this)
        {
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
            if (jobs.size() > 0)
            {
                String removedJob = jobs.remove(0);
                System.out.println("Removed Job: " + removedJob);
                Thread.sleep(1000);
            }
        }
    }
}
