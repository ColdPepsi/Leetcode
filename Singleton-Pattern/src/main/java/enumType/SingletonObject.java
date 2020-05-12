package enumType;

/**
 * @author WuBiao
 * @date 2020/5/12 9:51
 */
public class SingletonObject {

    private SingletonObject() {
    }

    private enum Singleton {//枚举内部类
        INSTANCE;
        private final SingletonObject singletonObject;

        Singleton() {
            singletonObject = new SingletonObject();
        }

        private SingletonObject getSingletonObject() {
            return singletonObject;
        }

    }
    public static SingletonObject getInstance() {
        return Singleton.INSTANCE.getSingletonObject();
    }
}
