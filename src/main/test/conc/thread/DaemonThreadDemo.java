package conc.thread;

public class DaemonThreadDemo
{
    public static void main(String[] args)
    {
        new WorkerThread(true).start();
        new WorkerThread(false).start();

        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            // handle here exception
        }

        System.out.println("Main Thread ending") ;
    }
}

class WorkerThread extends Thread {

    public WorkerThread(boolean isDaemon) {
        // When false, (i.e. when it's a user thread),
        // the Worker thread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the Worker thread terminates when the main
        // thread terminates.
        setDaemon(isDaemon);
    }

    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from Worker "+count++ + ", " + Thread.currentThread().getName() + ", isDaemon: " +
                    isDaemon() );
            if(count > 5 && !isDaemon()) {
                break;
            }

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                // handle exception here
            }
        }
    }
}
