import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * This program is simple demonstration of thread coordination
 * using Semaphore. Consumer will wait
 * till the consumer semaphore available. 
 * 
 */
public class ProducerConsumerWaitAndNotifyUsingSemaphore
{
    private List<String> jobs = new ArrayList<>();
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private CountDownLatch latch;

    ProducerConsumerWaitAndNotifyUsingSemaphore(Semaphore producerSemaphore, Semaphore consumerSemaphore)
    {
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Program Started...");
        Semaphore producerSemaphore = new Semaphore(2);
        Semaphore consumerSemaphore = new Semaphore(0);
        
        ProducerConsumerWaitAndNotifyUsingSemaphore producerConsumer = 
        	new ProducerConsumerWaitAndNotifyUsingSemaphore(producerSemaphore, consumerSemaphore);

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
        Thread consumer2 = new Thread(consumerRunnable, "Consumer2");
        Thread consumer3 = new Thread(consumerRunnable, "Consumer3");
        Thread consumer4 = new Thread(consumerRunnable, "Consumer4");


        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        consumer.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();


        consumer.join();

    }

    public void produce() throws InterruptedException
    {
    	
    	Random random = new Random();
        System.out.println("Available Permits: " + producerSemaphore.availablePermits());
        System.out.println("\n\n\n\n");
        
        producerSemaphore.acquire();
        String job = "Job " + random.nextInt(100);
        synchronized(this){
        	System.out.println("============================================================");
        	 System.out.println("Thread: " + Thread.currentThread().getName());
        	jobs.add(job);
            System.out.println("Added Job: " + job);            
            System.out.println("Available Permits" + producerSemaphore.availablePermits());
            System.out.println();
            
            System.out.println("Consumer Permits before: " + consumerSemaphore.availablePermits());
            if(consumerSemaphore.availablePermits() < 1){
            	consumerSemaphore.release();
            }
            System.out.println("Consumer Permits after: " + consumerSemaphore.availablePermits());
            System.out.println("============================================================");
            Thread.sleep(1000);
        }
       
       /* producerSemaphore.acquire();
        
        System.out.println("============================================================");
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("============================================================");
       
        System.out.println("Available Permits" + producerSemaphore.availablePermits());
        //System.out.println("Drained Permits" + semaphore.drainPermits());
        System.out.println("Queue Length" + producerSemaphore.getQueueLength());
        System.out.println("Queued Threads" + producerSemaphore.hasQueuedThreads());

        System.out.println("Pro Job size: " + jobs.size());

        String job = "Job " + random.nextInt(100);
        jobs.add(job);
        System.out.println("Added Job: " + job);

        //semaphore.release();
        System.out.println("Available Permits" + producerSemaphore.availablePermits());
        //System.out.println("Drained Permits" + semaphore.drainPermits());
        System.out.println("Queue Length" + producerSemaphore.getQueueLength());
        System.out.println("Queued Threads" + producerSemaphore.hasQueuedThreads());
        System.out.println("semaphore released...");
        System.out.println();
        */

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

    	 System.out.println("Consumer : " + Thread.currentThread());
    	consumerSemaphore.acquire();
        synchronized (this)
        {
            System.out.println("Cons Job size: " + jobs.size());

            System.out.println("Before removing");
            Thread.sleep(1000);
            String removedJob = jobs.remove(0);
            System.out.println("Removed Job: " + removedJob);
            producerSemaphore.release();
        }
        //consumerSemaphore.release();


    }
}
