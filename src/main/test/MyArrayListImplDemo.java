import org.baali.core.list.MyArrayList;

import java.util.List;

public class MyArrayListImplDemo
{
    public static void main(String[] args)
    {
        List<String> list = new MyArrayList<>();

        list.add("B");
        list.add("C");
        list.add(0, "A");
        list.remove(1);

        System.out.println("Size of list " + list.size() + " List: " + list);

        System.out.println(" ]");

      /*  String[] arr = new String[]{"a", "b", "c", "d", "", ""};

        String[] arr2 = new String[]{"Z"};
        //  System.arraycopy(data, index+1, data, index, count - index);
        System.arraycopy(arr, 2, arr, 3, 3);
        arr[2] = "Z";
        System.out.println("Array Copy: ");
        System.out.print("Arr["  );
        for (String s : arr)
        {
            System.out.print(s + ", ");
        }

        System.out.println(" ]");*/
    }
}
