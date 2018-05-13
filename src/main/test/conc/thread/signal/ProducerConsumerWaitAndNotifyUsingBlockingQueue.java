package conc.thread.signal;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This program is simple demonstration of thread coordination
 * using BlockingQueue data structure
 *
 * .
 */
class ProducerConsumerWaitAndNotifyUsingBlockingQueue
{
    //private List<String> jobs = new ArrayList<>();
    private BlockingQueue<String> jobs = new ArrayBlockingQueue<>(1);


    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Program Started...");
        ProducerConsumerWaitAndNotifyUsingBlockingQueue producerConsumer = new ProducerConsumerWaitAndNotifyUsingBlockingQueue();

        Thread producer = new Thread(() -> {
            System.out.println("Producer thread started..");
            try
            {
                // this will amke consumer to run 1st
                Thread.sleep(500);
                producerConsumer.produce();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "ProducerThread");

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
        }, "ConsumerThread");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }

    private void produce() throws InterruptedException
    {
        Random random = new Random();

        while (true)
        {
            String j = "Jobs " + random.nextInt(100);
            System.out.println("jobs " + j + "added " + jobs.offer(j));
            System.out.println();
            //System.out.println("Added Job: " + j);

            Thread.sleep(1000);
        }


    }


    private void consume() throws InterruptedException
    {
        //latch.await();


        while (true)
        {
            System.out.println("Cons Job size: " + jobs.size());
            String removedJob = jobs.take();
            System.out.println("Removed Job: " + removedJob);
            Thread.sleep(10000);
        }

    }
}
