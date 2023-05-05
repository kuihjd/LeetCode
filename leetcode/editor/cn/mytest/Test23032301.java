package leetcode.editor.cn.mytest;

public class Test23032301 {

    public static void main(String[] args) throws InterruptedException {
        new A().start();
        new B().start();
        Thread.sleep((long) 1e9);
    }

    // 生产者
    static class A extends Thread {
        static final int n = 5;
        @Override
        public void run() {
            while (true) {
                synchronized (C.getLock()) {
                    try {
                        C.add(n);
                        System.out.printf("当前剩余%d个 - 生产\n", C.get());
                        Thread.sleep(1000);
                        C.getLock().notifyAll();
                        C.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }

    // 消费者
    static class B extends Thread {
        static final int n = 1;
        @Override
        public void run() {
            while (true) {
                synchronized (C.getLock()) {
                    C.consume(n);
                    System.out.printf("当前剩余%d个 - 消费\n", C.get());
                    try {
                        Thread.sleep(1000);
                        C.getLock().notifyAll();
                        C.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }

    // 物品
    static class C {
        static Object lock = new Object();

        static int v = 10;

        static void add(int n) {
            v += n;
        }

        static void consume(int n) {
            v -= n;
        }

        static int get() {
            return v;
        }

        static Object getLock() {
            return lock;
        }

    }
}
