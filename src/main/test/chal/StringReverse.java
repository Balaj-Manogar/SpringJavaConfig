package chal;

public class StringReverse
{
    public static void main(String[] args)
    {
        String s = "helloABC";

        System.out.println(reverseRecursively(s));
        System.out.println(reverseIteratively(s));
    }

    private static String reverseRecursively(String s)
    {
        if (s.isEmpty() || s.length() == 1)
        {
            return s;
        }
        String first = s.substring(0, 1);
        String second = s.substring(1, s.length());

        return reverseRecursively(second) + first;
    }

    private static String reverseIteratively(String s)
    {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++)
        {
            char temp = arr[i];
            arr[i] = arr[(arr.length -i) -1];
            arr[(arr.length - i)-1] = temp;

        }
        return new String(arr);
    }
}
