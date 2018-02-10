import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo
{

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException
    {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        final Object[] elementData = (Object[]) field.get(list);

        System.out.println("list size before delete " + list.size());
        System.out.println("Actual list size before delete " + elementData.length);
        list.clear();
        System.out.println();
        System.out.println("list size after delete " + list.size());
        System.out.println("Actual list size after delete " + elementData.length);
        //System.out.println("Mod count " + list.getModCount());


    }
}
