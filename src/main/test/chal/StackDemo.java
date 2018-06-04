package chal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackDemo
{
    Class<?> c = Integer.TYPE;
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> pair = new HashMap<>();
    char[] inputArr;

    StackDemo()
    {
        pair.put('}', '{' );
        pair.put(']', '[');
        pair.put(')', '(');
    }

    public boolean check()
    {
        char temp;
        for(char c : inputArr){
            boolean hasClosedChar = pair.keySet().contains(c);
            if(hasClosedChar && stack.empty())
                return false;
            if(hasClosedChar ) {
                System.out.println("Closed char stack:" + stack);
                temp = stack.peek();
                if(pair.get(c) == temp )
                    stack.pop();
                else
                    return false;
            } else {
                stack.add(c);
            }
        }
        return stack.empty();

    }
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        StackDemo solution = new StackDemo();

        while (sc.hasNext())
        {
            String input = sc.next();
            System.out.println("input " + input);
            solution.inputArr = input.toCharArray();
            if (solution.validate())
            {
                System.out.println(solution.check());
            }else {
                // just to print
                System.out.println(false);
            }

        }
    }

    public boolean validate()
    {
        if (this.inputArr.length == 0 || inputArr.length % 2 == 1)
        {
            System.out.println("Not a valid string");
            return false;
        }

        return true;
    }
}
