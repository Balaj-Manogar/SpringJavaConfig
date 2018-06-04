package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MaximumTip
{
    public static void main(String[] args)
    {
        List<Integer> output = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        // number o test cases
        int testCaseCount = sc.nextInt();
        sc.nextLine();
        // orders and x, y order count

        String[] nxy = sc.nextLine().trim().split("\\s");
        int n = Integer.parseInt(nxy[0]);
        int x = Integer.parseInt(nxy[1]);
        int y = Integer.parseInt(nxy[2]);


        String[] rahulDataRaw = sc.nextLine().split("\\s");
        String[] ankitDataRaw = sc.nextLine().split("\\s");

        int[] rahulData = new int[rahulDataRaw.length];
        int[] ankitData = new int[ankitDataRaw.length];

        for (int i = 0; i < rahulDataRaw.length; i++)
        {
            rahulData[i] = Integer.parseInt(rahulDataRaw[i]);
        }
        for (int i = 0; i < ankitDataRaw.length; i++)
        {
            ankitData[i] = Integer.parseInt(ankitDataRaw[i]);
        }

        Stream<Integer> rahulStream = Arrays.stream(rahulData).boxed();
        Stream<Integer> ankitStream = Arrays.stream(ankitData).boxed();

        Stream<Integer> combinedStream = Stream.concat(rahulStream, ankitStream);

        Integer maxTip = combinedStream.sorted(Collections.reverseOrder()).limit(n)
                .reduce(0, (a, b) -> a + b);
        output.add(maxTip);
        System.out.println(maxTip);

        /*System.out.println("testcount: " + testCaseCount + ", nxy = " + Arrays.toString(nxy) + ", Rahul: " + Arrays.toString
                (rahulData) +
                ", Ankit: " + Arrays.toString(ankitData));*/


        //for ()
    }
}
