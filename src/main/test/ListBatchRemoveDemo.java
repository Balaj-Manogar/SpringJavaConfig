import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListBatchRemoveDemo
{
    public static void main(String[] args)
    {
        List<String> lists = new ArrayList<>();
        lists.add("ABC");
        lists.add(null);
        lists.add("BCD");
        lists.add("DEG");
        lists.add("GHI");


        //lists.removeAll(Collections.singleton(null));
        lists.removeAll(Arrays.asList("BCD", "GHI"));
    }
}
