package test;

import main.SimpleHashSet;

/**
 * Test class for {@link SimpleHashSet} class.
 * 
 */
public class SimpleHashSetTest {

    public static void main(String[] args) {
        SimpleHashSet<String> set = new SimpleHashSet();
        set.add("New Delhi");
        set.add("New Delhi");
        set.add("Gurugram");
        System.out.println("Size of set is: " + set.size());
        System.out.println("Set is: " + set.entrySet());
        System.out.println("Set contains element Gurugram: " + set.contains("Gurugram"));
        set.remove("Gurugram");
        System.out.println("Size of set is: " + set.size());
        System.out.println("Set is: " + set.entrySet());
        System.out.println("Set contains element Gurugram: " + set.contains("Gurugram"));
        System.out.println("Set contains element New Delhi: " + set.contains("New Delhi"));
    }
}
