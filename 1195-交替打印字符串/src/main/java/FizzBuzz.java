import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author wubiao21 2020年07月09日 17:13:43
 */
public class FizzBuzz {
    private int n;
    private Semaphore number = new Semaphore(1);
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.acquire();
                printBuzz.run();
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i < n + 1; i++) {
            if (i % 15 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                number.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < n + 1; i++) {
            number.acquire();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                number.release();
            } else if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.release();
            } else if (i % 3 == 0) {
                fizz.release();
            } else {
                buzz.release();
            }
        }
    }
}