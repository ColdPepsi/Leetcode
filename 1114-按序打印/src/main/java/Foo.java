import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WuBiao
 * @date 2020/4/2 16:31
 */
public class Foo {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    private int num = 1;


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        while (num != 1) {
            condition.await();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        num = 2;
        condition.signalAll();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (num != 2) {
            condition.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        num = 3;
        condition.signalAll();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (num != 3) {
            condition.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        num = 1;
        condition.signalAll();
        lock.unlock();
    }
}