package thread;

public class FooBar {
    private int n;
    private Object lock = new Object();
    private boolean isFooFinished = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (!isFooFinished) {
                    lock.wait();
                }
                printFoo.run();
                isFooFinished =false;
                lock.notifyAll();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (isFooFinished) {
                    lock.wait();
                }
                printBar.run();
                isFooFinished = true;
                lock.notifyAll();
            }
        }
    }
}
