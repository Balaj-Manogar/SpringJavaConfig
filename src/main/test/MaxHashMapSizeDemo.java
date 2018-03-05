import java.util.HashMap;
import java.util.Map;

public class MaxHashMapSizeDemo
{
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < 1073741834; i++)
        {
            String key =  "key" + i;
            String val = "al";
            map.put(key, val);

        }
        System.out.println("Map size: " + map.size());
    }
}
