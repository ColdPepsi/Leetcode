import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 采用继承的形式，不能采用依赖的形式，因为要重写removeEldestEntry方法
 *
 * @author WuBiao
 * @date 2020/5/13 11:54
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache2(int capacity) {
        super(capacity * 2, 0.75f, true);
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