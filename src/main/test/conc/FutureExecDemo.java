package conc;

public class FutureExecDemo
{

    public static void main(String[] args)
    {
        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<>();
        Future<Integer> future11 = (num1) -> {
            System.out.println(" Current thread: " + Thread.currentThread() + ", i = " + num1);
            try
            {
                throw new Exception("exception on 11th loop");
                //Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " is finished.");
        };

        Future<Integer> futureOthers = (num) -> {
            System.out.println(" Current thread: " + Thread.currentThread() + ", i = " + num);
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " is finished.");
            return
        };
        for (int i = 0; i < 26; i++)
        {
            int[] idx = new int[]{i};
            if (idx[0] == 11)
            {
                executorService.submit(() -> {
                    System.out.println(" Current thread: " + Thread.currentThread() + ", i = " + idx[0]);
                    try
                    {
                        throw new Exception("exception on 11th loop");
                        //Thread.sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " is finished.");
                });
            } else {
                executorService.submit(() -> {
                    System.out.println(" Current thread: " + Thread.currentThread() + ", i = " + idx[0]);
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " is finished.");
                });
            }

            for (int i = 0; i < 26; i++) {

            }
        }*/
    }
}
