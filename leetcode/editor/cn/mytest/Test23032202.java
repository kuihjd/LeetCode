package leetcode.editor.cn.mytest;

// 框最大50个包子 厨师一秒一次生产5个 客人一秒2个 厨师需要在<=10补充到满

// id name grade

// SELECT
public class Test23032202 {
    public static void main(String[] args) {
        new A().start();
        new B().start();

    }

    // 厨师
    static class A extends Thread {
        @Override
        public void run() {
            while (true) {
                while (C.get() < 50) {
                    C.add(5);
                    System.out.println("厨师生产5，当前" + C.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    C.object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 客人
    static class B extends Thread {
        @Override
        public void run() {
            while (true) {
                C.consume(2);
                System.out.println("客人消耗2，当前" + C.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 包子
    static class C {
        static int n = 0;
        static Object object = new Object();

        static synchronized void consume(int v) {
            n -= v;
            if (10 <= n) {
                object.notifyAll();
            }
        }

        static synchronized int add(int v) {
            n += v;
            if (n > 50) {
                n = 50;
            }
            return n;
        }

        static int get() {
            return n;
        }
    }


}
