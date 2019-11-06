package MyHashMap;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class HashMapRealizationTest {
    HashMapRealization<Character, Integer> hash = new HashMapRealization();
    private final int M = 16;
    HashMap<Character, Integer> controlMap = new HashMap<>();




    @Test
    public void put() {
        hash.put('A', 2);
        hash.put('B', 2);
        hash.put('C', 2);
        hash.put('D', 2);
        hash.put('E', 2);
        hash.put('F', 2);
        hash.put('G', 2);
        hash.put('H', 2);
        hash.put('J', 2);
        hash.put('K', 2);
        hash.put('L', 2);
        hash.put('M', 2);
        hash.put('N', 2);
        hash.put('O', 2);
        hash.put('P', 2);
        hash.put('Q', 2);
        hash.put('R', 2);
        hash.put('S', 2);
        hash.put('T', 2);
        hash.put('U', 2);
        hash.put('V', 2);

        controlMap.put('A', 2);
        controlMap.put('B', 2);
        controlMap.put('C', 2);
        controlMap.put('D', 2);
        controlMap.put('E', 2);
        controlMap.put('F', 2);
        controlMap.put('G', 2);
        controlMap.put('H', 2);
        controlMap.put('J', 2);
        controlMap.put('K', 2);
        controlMap.put('L', 2);
        controlMap.put('M', 2);
        controlMap.put('N', 2);
        controlMap.put('O', 2);
        controlMap.put('P', 2);
        controlMap.put('Q', 2);
        controlMap.put('R', 2);
        controlMap.put('S', 2);
        controlMap.put('T', 2);
        controlMap.put('U', 2);
        controlMap.put('V', 2);

        Assert.assertEquals(controlMap.size(),hash.size());
    }

    @Test
    public void size() {
        hash.put('A', 2);
        hash.put('A', 3);
        hash.put('A', 4);
        hash.put('C', 2);
        hash.put('B', 2);

        controlMap.put('A', 2);
        controlMap.put('A', 3);
        controlMap.put('A', 4);
        controlMap.put('C', 2);
        controlMap.put('B', 2);

        Assert.assertEquals(controlMap.size(),hash.size());

    }

    @Test
    public void isEmpty() {
        hash.put('D', 2);

        controlMap.put('B', 2);

        Assert.assertEquals(controlMap.isEmpty(),hash.isEmpty());

    }


    @Test
    public void get() {
        hash.put('J', 10);

        controlMap.put('J', 10);

        Assert.assertEquals(controlMap.get('J'),hash.get('J'));
    }


    @Test
    public void containsKey() {
        hash.put('J', 10);

        controlMap.put('J', 10);

        Assert.assertEquals(controlMap.containsKey('A'),hash.containsKey('A'));

    }

    @Test
    public void remove() {
        hash.put('A', 2);
        hash.put('A', 3);
        hash.put('B', 2);
        hash.remove('A');

        controlMap.put('A', 2);
        controlMap.put('A', 3);
        controlMap.put('B', 2);
        controlMap.remove('A');

        Assert.assertEquals(controlMap,hash);

    }


    @Test
    public void containsValue() {
        hash.put('A', 2);
        hash.put('B', 3);
        hash.put('C', 4);
        hash.put('D', 5);
        hash.put('E', 6);
        hash.put('F', 7);
        hash.put('G', 8);
        hash.put('H', 9);

        controlMap.put('A', 2);
        controlMap.put('B', 3);
        controlMap.put('C', 4);
        controlMap.put('D', 5);
        controlMap.put('E', 6);
        controlMap.put('F', 7);
        controlMap.put('G', 8);
        controlMap.put('H', 9);
        Assert.assertEquals(controlMap.containsValue(2),hash.containsValue(2));
    }

    @Test
    public void clear() {
        hash.put('A', 2);
        hash.put('B', 3);
        hash.put('C', 4);
        hash.put('D', 5);
        hash.put('E', 6);
        hash.put('F', 7);
        hash.put('G', 8);
        hash.put('H', 9);
        hash.clear();

        controlMap.put('A', 2);
        controlMap.put('B', 3);
        controlMap.put('C', 4);
        controlMap.put('D', 5);
        controlMap.put('E', 6);
        controlMap.put('F', 7);
        controlMap.put('G', 8);
        controlMap.put('H', 9);
        controlMap.clear();
        Assert.assertEquals(controlMap,hash);
    }

    @Test
    public void putAll() {
        hash.put('A', 2);
        hash.put('B', 3);
        hash.put('C', 4);
        hash.put('D', 5);
        hash.put('E', 6);
        hash.put('F', 7);
        hash.put('G', 8);
        hash.put('H', 9);
        //hash.putAll(Map<Character, Integer> map);

        controlMap.put('A', 2);
        controlMap.put('B', 3);
        controlMap.put('C', 4);
        controlMap.put('D', 5);
        controlMap.put('E', 6);
        controlMap.put('F', 7);
        controlMap.put('G', 8);
        controlMap.put('H', 9);
    }


    @Test
    public void keySet() {
        hash.put('A', 2);
        hash.put('A', 3);
        hash.put('B', 3);
        hash.put('C', 4);
        hash.put('D', 5);
        hash.put('E', 6);
        hash.put('F', 7);
        hash.put('G', 8);
        hash.put('H', 9);
        hash.remove('A');

        controlMap.put('A', 2);
        controlMap.put('A', 3);
        controlMap.put('B', 3);
        controlMap.put('C', 4);
        controlMap.put('D', 5);
        controlMap.put('E', 6);
        controlMap.put('F', 7);
        controlMap.put('G', 8);
        controlMap.put('H', 9);
        controlMap.remove('A');
        Assert.assertEquals(controlMap.keySet(),hash.keySet());

    }

    @Test
    public void values() {
        hash.put('A', 2);
        hash.put('A', 3);
        hash.put('B', 3);
        hash.put('C', 4);
        hash.put('D', 5);
        hash.put('E', 6);
        hash.put('F', 7);
        hash.put('G', 8);
        hash.put('H', 9);
        hash.remove('A');

        controlMap.put('A', 2);
        controlMap.put('A', 3);
        controlMap.put('B', 3);
        controlMap.put('C', 4);
        controlMap.put('D', 5);
        controlMap.put('E', 6);
        controlMap.put('F', 7);
        controlMap.put('G', 8);
        controlMap.put('H', 9);
        hash.remove('A');
        for (Map.Entry m: controlMap.entrySet()) {
            Assert.assertTrue(hash.containsValue(m.getValue()));
        }
    }

    @Test
    public void entrySet() {
        hash.put('A', 2);
        hash.put('B', 3);
        hash.put('C', 4);
        hash.put('D', 5);
        hash.put('E', 6);
        hash.put('F', 7);
        hash.put('G', 8);
        hash.put('H', 9);
        hash.remove('A');

        controlMap.put('A', 2);
        controlMap.put('B', 3);
        controlMap.put('C', 4);
        controlMap.put('D', 5);
        controlMap.put('E', 6);
        controlMap.put('F', 7);
        controlMap.put('G', 8);
        controlMap.put('H', 9);
        controlMap.remove('A');
        Assert.assertEquals(controlMap.entrySet(),hash.entrySet());
    }
}