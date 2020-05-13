import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 主要继承linkedHashMap，这种思想很好
 *
 * @author WuBiao
 * @date 2020/5/12 22:09
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache(int capacity) {//accessOrder会把访问过的元素放在最后面
        super(2 * capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}