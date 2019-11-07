package main;

import sun.awt.image.ImageWatched;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * A simple implementation of Set which can hold unique elements.
 *
 * @param <E>
 */
public class SimpleHashSet<E> {
    static final int SIZE = 64;
    LinkedList<E>[] buckets = new LinkedList[SIZE];
    int currentSize = 0;

    /**
     * Adds the given element to set.
     *
     * @param value
     * @return Returns true if element does not exists already and added successfully.
     */
    public boolean add(E value) {
        int index = Math.abs(value.hashCode()) % SIZE;
        LinkedList<E> list = buckets[index];
        if(list == null) {
            list = new LinkedList<>();
            list.add(value);
            buckets[index] = list;
            currentSize++;
            return true;
        }
        return false;
    }

    /**
     * Removes given element from the set.
     *
     * @param value
     * @return Returns true if element exists in set and removed successfully.
     */
    public boolean remove(E value) {
        int index = Math.abs(value.hashCode()) % SIZE;
        LinkedList<E> list = buckets[index];
        if(list == null) {
            return false;
        } else {
            list = null;
            buckets[index] = null;
            currentSize--;
            return true;
        }
    }

    /**
     * Returns true if element exists in set.
     *
     * @param value
     * @return
     */
    public boolean contains(E value) {
        int index = Math.abs(value.hashCode()) % SIZE;
        return (buckets[index] != null);
    }

    /**
     * Returns the number of elements currently present in set.
     *
     * @return
     */
    public int size() {
        return currentSize;
    }

    /**
     * Returns set of all the entries present in this set.
     *
     * @return
     */
    public Set<E> entrySet() {
        Set<E> set = new HashSet<>();
        for(LinkedList<E> list : buckets) {
            if(list != null) {
                set.add(list.get(0));
            }
        }
        return set;
    }
}
