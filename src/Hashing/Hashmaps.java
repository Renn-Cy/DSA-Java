package Hashing;
import java.util.HashMap;
import java.util.Set;

public class Hashmaps
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> hMap = new HashMap<>();

        hMap.put("Vitality", 87);
        hMap.put("Endurance", 30);
        hMap.put("Stamina", 49);
        hMap.put("Speed", 88);
        hMap.put("Intelect", 63);

        System.out.println(hMap);

        int vitals = hMap.get("Vitality");
        System.out.println(vitals);

        System.out.println(hMap.containsKey("Speed"));

        hMap.remove("Stamina");

        System.out.println(hMap.size());

        hMap.clear();

        System.out.println(hMap.isEmpty());

        //Iterate over a HashMap
        Set<String> keys = hMap.keySet();
        System.out.println(keys );

        for (String k : keys)
        {
            System.out.println("key=" + k + ", value=" + hMap.get(k));
        }
    }
}
