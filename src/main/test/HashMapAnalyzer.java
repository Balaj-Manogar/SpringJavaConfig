import java.util.HashMap;
import java.util.Map;

public class HashMapAnalyzer
{
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();

        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        map.put("Key1", "Value1");
    }

}
