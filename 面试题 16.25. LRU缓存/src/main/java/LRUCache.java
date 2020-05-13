import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/5/12 21:06
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> linkedHashMap;
    private final int Capacity;

    public LRUCache(int capacity) {
        Capacity = capacity;
        linkedHashMap = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        if (!linkedHashMap.containsKey(key)) {
            return -1;
        }
        //每次访问元素，该元素出队，加到队尾
        Integer temp = linkedHashMap.remove(key);
        linkedHashMap.put(key, temp);
        return temp;
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);//删除原来的元素
        }
        linkedHashMap.put(key, value);//加到队尾
        //超容量，删除队首元素
        if (linkedHashMap.size() > Capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = linkedHashMap.entrySet().iterator();
            linkedHashMap.remove(iterator.next().getKey());
        }
    }
}