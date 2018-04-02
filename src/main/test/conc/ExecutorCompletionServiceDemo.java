//'main' method must be in a class 'Rextester'.
//Compiler version 1.8.0_111

import java.util.*;
import java.util.concurrent.*;
import java.lang.*;

class ExecutorCompletionServiceDemo
{  
    public static void main(String args[]) throws Exception
    {
        System.out.println("Hello, World!" + args.length);
        ExecutorService exec = Executors.newFixedThreadPool(5);
        CompletionService<Integer> service = new ExecutorCompletionService<Integer>(exec);
        
        
        service.submit(()-> {
            try {
                Thread.sleep(1500);
                System.out.println("first callable is finished...");
               
            }catch (InterruptedException e) {
                System.out.println("first callable is interrupted");
            }
             return 100;
        });
        
        service.submit(()-> {
            try {
                Thread.sleep(2000);
                System.out.println("second callable is finished...");
                
            }catch (InterruptedException e) {
                System.out.println("second callable is interrupted");
            }
            return 200;
        });
        
        service.submit(()-> {
            try {
                Thread.sleep(1000);
                System.out.println("third callable is finished...");
               
            }catch (InterruptedException e) {
                System.out.println("third callable is interrupted");
            }
             return 300;
        });
        
        for(int i = 0; i < 3; i++) {
            System.out.println(service.take().get());
        }
        
        exec.shutdown();
        
        

    }
}
