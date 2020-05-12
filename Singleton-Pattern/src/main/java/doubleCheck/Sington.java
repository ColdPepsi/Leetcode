package doubleCheck;

/**
 * @author WuBiao
 * @date 2020/5/12 10:03
 */
public class Sington {

    private volatile static Sington sington = null;//注意volatile关键字

    private Sington() {
    }//私有化构造器

    public static Sington getInstance() {
        if (sington == null) {
            synchronized (Sington.class) {
                if (sington == null) {
                    sington = new Sington();
                }
            }
        }
        return sington;
    }
}
