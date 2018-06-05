package code;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pair
{
    public static void main(String[] args)
    {
        //int[] num = new int[]{1, -3, 2, 3, 6, -1};
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        sc.nextLine();
        int[] totalElements = new int[testCaseCount];
        String[][] inputData = new String[testCaseCount][];
        for (int a = 0; a < testCaseCount; a++)
        {
            int numElements = sc.nextInt();
            sc.nextLine();
            totalElements[a] = numElements;

            String[] inputs = sc.nextLine().trim().split(" ");
            inputData[a] = inputs;

        }
        for (int b = 0; b < testCaseCount; b++)
        {
            int[] num = new int[totalElements[b]];
            String[] inputs = inputData[b];
            System.out.println(Arrays.toString(inputs));

            for (int i = 0; i < inputs.length; i++)
            {
                num[i] = Integer.parseInt(inputs[i]);
            }

            System.out.println("abbc");

            String output = getPair(num, 1, num.length, 0).trim();
            output = output.length() > 0 ? output : "0";
            output =  Arrays.stream(output.split(" ")).map(e -> Integer.parseInt(e))
                    .sorted(Integer::compareTo)
                    .map(e -> String.valueOf(e)).collect(Collectors.joining(" "));
            System.out.println(output);
        }

    }

    static String getPair(int[] num, int currentIndex, int maxlength, int sortNumber)
    {
        StringBuilder s = new StringBuilder("");
        int index = currentIndex;
        int current = num[index - 1];
        int matched = 0;
        if (currentIndex >= maxlength - 1)
        {
            return s.toString();
        }
        for (int i = index; i < num.length; i++)
        {
            if (current + num[i] == 0)
            {
                int min = Math.min(current, num[i]);
                int max = Math.max(current, num[i]);
                s.append( min + " " + max + " ");
                System.out.println("Paired " + current + num[i]);
            }
        }
        ++index;
        return s + getPair(num, index, maxlength, matched);
    }
}
