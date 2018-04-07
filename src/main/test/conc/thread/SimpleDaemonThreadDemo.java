package conc.thread;

public class SimpleDaemonThreadDemo
{
    public static void main(String args[])
    {
        System.out.println("Hello, World: ");
        Thread t1 = new Thread(() -> {
            System.out.println("t1 Thread start....");
            try
            {
                Thread.sleep(2000);
                System.out.println("t1 Thread end....");
            }
            catch (InterruptedException e)
            {
                System.out.println("t1 thread interruputed....");
            }
            finally
            {
                System.out.println("t1 in finallyblock....");
            }

            });
            Thread d1 = new Thread(() -> {
                System.out.println("d1 Thread start....");
                try
                {
                    Thread.sleep(4000);
                    System.out.println("d1 Thread end....");
                }
                catch (Exception e)
                {
                    System.out.println("d1 thread interruputed...." + e);
                }
                finally
                {
                    System.out.println("d1 in finally block....");
                }

            });
            d1.setDaemon(true);
            t1.start();
            d1.start();

        }
    }
