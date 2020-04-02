import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WuBiao
 * @date 2020/4/2 15:53
 */
public class DiningPhilosophers {

    private ReentrantLock[] forks = {new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),
            new ReentrantLock(),new ReentrantLock()};
    private Semaphore eatLimits = new Semaphore(3);//用信号量表示最多3个人进餐


    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int rightForkIndex = (philosopher + 1) % 5;//获取右边叉子

        eatLimits.acquire();//改变信号量 准备就餐

        forks[philosopher].lock();//左右筷子加锁
        forks[rightForkIndex].lock();

        pickLeftFork.run();//拿起左右筷子
        pickRightFork.run();

        eat.run();//开吃

        putLeftFork.run();//放下左右筷子
        putRightFork.run();

        forks[philosopher].unlock();//左右筷子解锁
        forks[rightForkIndex].unlock();

        eatLimits.release();//释放信号量
    }
}