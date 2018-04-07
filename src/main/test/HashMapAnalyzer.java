import java.util.HashMap;
import java.util.Map;

public class HashMapAnalyzer
{
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();

        String key1 = "Key1";
        System.out.println("HashCode: " + key1.hashCode() + ", Binary: " + Integer.toBinaryString(key1.hashCode()));

        System.out.println("XOR: " +  (key1.hashCode() >>> 16) + ", Binary: " + Integer.toBinaryString(key1.hashCode() >>> 16));
        map.put(key1, "Value1");
        map.put("Key2", "Value2");
        map.put("Key1", "Value1");
    }

    // 1000111010000111010010

}
