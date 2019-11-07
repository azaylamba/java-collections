package test;

import main.SimpleHashMap;

/**
 * Test class for {@link SimpleHashMap}.
 *
 */
public class SimpleHashMapTest {
    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.put("India", "New Delhi");
        m.put("CONOG", "Brazzavillett");
        m.put("CONGO", "Brazzaville");
        m.put("CONGO", "Brazzavillee");
        System.out.println("Map elements are: " + m);
        System.out.println("Capital of CONGO is: " + m.get("CONGO"));
        System.out.println("Map entry set is: " + m.entrySet());
        m.clear();
        m.remove("CONOG");
        System.out.println("Map entry set is: " + m.entrySet());
    }
}
