package thread;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private CountDownLatch zero = new CountDownLatch(0);
    private CountDownLatch even = new CountDownLatch(1);
    private CountDownLatch odd = new CountDownLatch(1);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1;i<=n;i++) {
            zero.await();
            printNumber.accept(0);
            zero = new CountDownLatch(1);
            if ((i & 1) == 1) {
                odd.countDown();
            } else {
                even.countDown();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++) {
            if ((i & 1) == 0) {
                even.await();
                printNumber.accept(i);
                even = new CountDownLatch(1);
                zero.countDown();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++) {
            if ((i & 1) == 1) {
                odd.await();
                printNumber.accept(i);
                odd = new CountDownLatch(1);
                zero.countDown();
            }

        }
    }
}
