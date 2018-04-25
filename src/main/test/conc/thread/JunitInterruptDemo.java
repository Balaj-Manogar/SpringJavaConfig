package conc.thread;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JunitInterruptDemo
{
    @Test
    public void testInterruptStatus()
    {
        assertFalse(Thread.currentThread().isInterrupted());
// you can do this from another thread by saying: someThread.interrupt();
        Thread.currentThread().interrupt();
// this method does _not_ clear the interrupt flag
        assertTrue(Thread.currentThread().isInterrupted());
// but this one _does_ and should probably not be used
        assertTrue(Thread.interrupted());
        assertFalse(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        assertTrue(Thread.currentThread().isInterrupted());
        try
        {
            System.out.println(Thread.currentThread().isInterrupted());
            // this throws immediately because the thread is _already_ interrupted
            Thread.sleep(1);
            fail("will never get here");
        }
        catch (InterruptedException e)
        {
            System.out.println(Thread.currentThread().isInterrupted());
            // and when the InterruptedException is throw, it clears the interrupt
            assertFalse(Thread.currentThread().isInterrupted());
            // we should re-interrupt the thread so other code can use interrupt status
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
        }
        assertTrue(Thread.currentThread().isInterrupted());
    }
}
