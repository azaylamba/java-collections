package main;

import java.util.*;

/**
 * A simple hash map implementation using array of {@link LinkedList} as buckets. It has basic get and put methods.
 * The put method also reports collisions, if any and number of probes required to find out the collision.
 *
 * @param <K>
 * @param <V>
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    /**
     * Puts a value in map for the given key. It first calculates index as remainder of hashcode of key and SIZE of bucket.
     * It also reports any collisions occurred along with number of probes required to find out the collision.
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        int probes = 0;
        while(it.hasNext()) {
            System.out.println("Collision occurred for key: " + key);
            probes++;
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if(!found) {
            buckets[index].add(pair);
        } else {
            System.out.println("Number of probes: " + probes);
        }
        return oldValue;
    }

    /**
     * Returns value for the given key. It uses same method to calculate index using hashcode and SIZE of buckets.
     *
     * @param key
     * @return
     */
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) {
            return null;
        }
        for(MapEntry<K, V> iPair : buckets[index]) {
            if(iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    /**
     * Removes entry for the given key.
     *
     * @param key
     * @return
     */
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        V oldValue = null;
        if(buckets[index] == null) {
            return null;
        } else {
            LinkedList<MapEntry<K, V>> bucket = buckets[index];
            ListIterator<MapEntry<K, V>> it = bucket.listIterator();
            while(it.hasNext()) {
                MapEntry<K, V> me = it.next();
                if(me.getKey().equals(key)) {
                    System.out.println("Removing entry for key: " + key);
                    oldValue = me.getValue();
                    it.remove();
                    break;
                }
            }
        }
        return oldValue;
    }

    /**
     * Clears all entries of the map.
     *
     */
    public void clear() {
        System.out.println("Clearing the map");
        for(LinkedList<MapEntry<K, V>> bucket : buckets) {
            if(bucket != null) {
                bucket.clear();
            }
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for(LinkedList<MapEntry<K, V>> bucket : buckets) {
            if(bucket == null) {
                continue;
            }
            for(MapEntry<K, V> mPair : bucket) {
                set.add(mPair);
            }
        }
        return set;
    }
}
