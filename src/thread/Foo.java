package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class Foo {
    private volatile int num = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        num ++;
    }


    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
           if (num == 1) break;
        }
        printSecond.run();
        num++;
    }


    public void third(Runnable printThird) throws InterruptedException {
        while (true){
            if (num ==2) break;
        }
        printThird.run();
    }


    public class Foo1 {
        private CountDownLatch a1 = new CountDownLatch(1);
        private CountDownLatch a2 = new CountDownLatch(1);

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            a1.countDown();
        }


        public void second(Runnable printSecond) throws InterruptedException {
            a1.await();
            printSecond.run();
            a2.countDown();
        }


        public void third(Runnable printThird) throws InterruptedException {
            a2.await();
            printThird.run();
        }
    }

    public class Foo2 {
        private AtomicBoolean a1 = new AtomicBoolean(false);
        private AtomicBoolean a2 = new AtomicBoolean(false);

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            a1.set(true);
        }


        public void second(Runnable printSecond) throws InterruptedException {
            while (true) {
                if (a1.get()) break;
            }
            printSecond.run();
            a2.set(true);
        }


        public void third(Runnable printThird) throws InterruptedException {
            while (true) {
                if (a2.get())break;
            }
            printThird.run();
        }
    }


    public class Foo3 {
        private Object lock = new Object();
        private boolean firstFinished = false;
        private boolean secondFinished = false;

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }

        }


        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!firstFinished) {
                    lock.wait();
                }
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }

        }


        public void third(Runnable printThird) throws InterruptedException {
           synchronized (lock) {
               while (!secondFinished) {
                   lock.wait();
               }
               printThird.run();
           }
        }


    }



}

