package thread;

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
}

