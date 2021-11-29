package thread;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton {

    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();


    /**
     * 通过CAS + Volatile 实现原子操作
     * 无阻塞的锁，采用不断比较设的值来避免并发的问题，不会有锁的等待和上下文切换，性能消耗小
     * @return
     */
    public static Singleton getInstance() {
        for(;;) {
            Singleton current = INSTANCE.get();
            if (current !=null) return current;
            current = new Singleton();
            if (INSTANCE.compareAndSet(null,current)) {
                return current;
            }
        }
    }



    private static volatile Singleton instance;
    public static Singleton getInstance1() {
        if (instance ==null) {//防止阻塞造成性能问题
            synchronized (Singleton.class) {
                if (instance ==null) { //防止A，B同时执行Synchronized造成重复创建实例
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }




}
