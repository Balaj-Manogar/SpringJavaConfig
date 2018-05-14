package conc.thread.signal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * This program is simple demonstration of wait and
 * notify using CountDownLatch. Consumer will wait
 * till the lock becomes zero. Disadvantage is we cannot
 * reuse this semaphore.
 */
class ProducerConsumerWaitAndNotifyUsingSemaphore
{
    private List<String> jobs = new ArrayList<>();
    private Semaphore semaphore;

    ProducerConsumerWaitAndNotifyUsingSemaphore(Semaphore semaphore)
    {
        this.semaphore = semaphore;
    }

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Program Started...");
        Semaphore semaphore = new Semaphore(10);
        ProducerConsumerWaitAndNotifyUsingSemaphore producerConsumer = new ProducerConsumerWaitAndNotifyUsingSemaphore(semaphore);

        Runnable producerRunnable = () -> {
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
        };

        Runnable consumerRunnable = () -> {
            System.out.println("Consumer thread started..");
            try
            {
                producerConsumer.consume();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        };
        Thread producer1 = new Thread(producerRunnable, "Producer1");
        Thread producer2 = new Thread(producerRunnable, "Producer2");
        Thread producer3 = new Thread(producerRunnable, "Producer3");
        Thread producer4 = new Thread(producerRunnable, "Producer4");
        Thread consumer = new Thread(consumerRunnable, "Consumer1");


        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        //consumer.start();


        //consumer.join();

    }

    public void produce() throws InterruptedException
    {
        semaphore.acquire();
        System.out.println("============================================================");
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("============================================================");
        Random random = new Random();
        System.out.println("Available Permits" + semaphore.availablePermits());
        System.out.println("Drained Permits" + semaphore.drainPermits());
        System.out.println("Queue Length" + semaphore.getQueueLength());
        System.out.println("Queued Threads" + semaphore.hasQueuedThreads());

        System.out.println("Pro Job size: " + jobs.size());

        String job = "Job " + random.nextInt(100);
        jobs.add(job);
        System.out.println("Added Job: " + job);

        //semaphore.release();
        System.out.println("Available Permits" + semaphore.availablePermits());
        System.out.println("Drained Permits" + semaphore.drainPermits());
        System.out.println("Queue Length" + semaphore.getQueueLength());
        System.out.println("Queued Threads" + semaphore.hasQueuedThreads());
        System.out.println("semaphore released...");
        System.out.println();
        Thread.sleep(1000);

       /* semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        System.out.println("Semaphore releases randomly......!!!!!....");
        System.out.println("Available Permits" + semaphore.availablePermits());
        System.out.println("Drained Permits" + semaphore.drainPermits());
        System.out.println("Queue Length" + semaphore.getQueueLength());
        System.out.println("Queued Threads" + semaphore.hasQueuedThreads());
        System.out.println("semaphore released...");*/

    }

    public void consume() throws InterruptedException
    {

        synchronized (this)
        {
            System.out.println("Cons Job size: " + jobs.size());

            System.out.println("Before removing");
            Thread.sleep(1000);
            String removedJob = jobs.remove(0);
            System.out.println("Removed Job: " + removedJob);
            semaphore.release();
        }


    }
}
