package conc.thread;

public class ThreadVisibilityCheckDemo
{
    private  boolean state = false;

    public static void main(String[] args)
    {
        ThreadVisibilityCheckDemo obj = new ThreadVisibilityCheckDemo();
        new Thread(() -> {
            while (!obj.state) {
                System.out.println( Thread.currentThread());
            }
            System.out.println("False state end...");
        }, "False_Thread").start();

        new Thread(() -> {
            obj.state = true;
            System.out.println( Thread.currentThread());
        }, "True_Thread").start();
    }

}
