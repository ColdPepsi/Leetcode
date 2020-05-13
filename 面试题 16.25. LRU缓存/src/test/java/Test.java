/**
 * @author WuBiao
 * @date 2020/5/12 21:53
 */
public class Test {

    @org.junit.Test
    public void test(){
        LRUCache lruCache=new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);
    }
}
