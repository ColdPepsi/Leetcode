import java.util.concurrent.Semaphore;

/**
 * 用信号量来解决交替打印问题
 *
 * @author WuBiao
 * @date 2020/5/17 13:00
 */
public class FooBar {
    private final int n;
    private final Semaphore fooSemaphore;
    private final Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;
        fooSemaphore = new Semaphore(1);
        barSemaphore = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}