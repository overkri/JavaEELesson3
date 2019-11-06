package MyHashMap;

import java.util.*;


public class HashMapRealization<Key, Value> implements Map<Key, Value> {

    public static void main(String[] args) {

    }

    private transient Set<Key> keySet;
    private transient Collection<Value> values;
    private transient Set<Entry<Key, Value>> entrySet;
    private int capacity = 16;
    private int treshold = 16;
    private int size = 0;
    private float loadFactor = 0.75f;
    private float multiplier = 1.5f;
    private Object[] st = new Object[capacity];

    public HashMapRealization() {
        keySet = new HashSet<>();
        entrySet = new HashSet<>();
        values = new ArrayList<>();
    }

    private class Node {
        Key key;
        Value value;
        HashMapRealization.Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.next = next;
            this.value = value;
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean containsValue(Object value) {
        Iterator<Entry<Key, Value>> i = this.entrySet().iterator();
        Entry e;
        if (value == null) {
            while (i.hasNext()) {
                e = i.next();
                if (e.getValue() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                e = i.next();
                if (value.equals(e.getValue())) {
                    return true;
                }
            }
        }

        return false;
    }


    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public Value get(Object key) {

        int i = hash((Key) key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }


    public Value remove(Object key) {
        int i = hash((Key) key);
        Node x = (Node) st[i];
        if ((size <= loadFactor * capacity) && (size / multiplier > treshold)) {
            int newcapacity = (int) Math.round(capacity / multiplier);
            Object[] st1 = new Object[newcapacity];
            System.arraycopy(st, 0, st1, 0, capacity);
            st = st1;
            capacity = newcapacity;

        }
        while (x != null) {
            if (key.equals(x.key)) {
                values.remove(x.value);
                entrySet.remove(new EntrySet(x.key, x.value));
                entrySet.remove(x.key);
                x.value = null;
            }
            x = x.next;
        }
        size--;
        keySet.remove(key);
        return null;
    }


    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public Value put(Key key, Value value) {
        if (size >= loadFactor * capacity) {
            int newcapacity = (int) Math.round(capacity * multiplier);
            Object[] st1 = new Object[newcapacity];
            System.arraycopy(st, 0, st1, 0, capacity);
            st = st1;
            capacity = newcapacity;
        }

        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return value;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]);
        size++;
        keySet.add(key);
        values.add(value);
        entrySet.add(new EntrySet(key, value));
        return value;

    }


    @Override
    public void putAll(Map<? extends Key, ? extends Value> map) {
        Set<?> mapKeys = map.keySet();

        for (Object key : mapKeys) {
            put((Key) key, map.get(key));

        }

    }


    @Override
    public void clear() {
        if (st != null && this.size > 0) {
            this.size = 0;

            for (int i = 0; i < st.length; ++i) {
                st[i] = null;
            }
        }
    }

    @Override
    public Set<Key> keySet() {
        return new HashSet<>(keySet);
    }


    @Override
    public Collection<Value> values() {
        Collection<Value> copy = new ArrayList<>(values);
        return copy;

    }


    @Override
    public Set<Entry<Key, Value>> entrySet() {
        Set<Entry<Key, Value>> copy = new HashSet<>(entrySet);
        return copy;

    }

    final class EntrySet implements Entry<Key, Value> {
        private Key key;
        private Value value;

        public EntrySet(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public Value getValue() {
            return value;
        }

        @Override
        public Value setValue(Value value) {
            Value v = this.value;
            this.value = value;
            return v;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Entry)  {
                if ((((Entry) o).getValue()) == this.value &&
                        (((Entry) o).getKey() == this.key)) {
                    return true;
                }

            }return false;

        }

        @Override
        public int hashCode() {
            return  Objects.hash();
        }
    }
}






