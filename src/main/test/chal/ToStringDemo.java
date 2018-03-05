package chal;

import java.util.ArrayList;
import java.util.List;

public class ToStringDemo
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.get(1).toString().toString().toString().toString());

    }
}
 /*   PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("Homer");
                priorityQueue.add("Marg");
                priorityQueue.add("Barg");

                priorityQueue.peek();

                System.out.println(priorityQueue.poll().toString().toString().toString().toString().toString());*/