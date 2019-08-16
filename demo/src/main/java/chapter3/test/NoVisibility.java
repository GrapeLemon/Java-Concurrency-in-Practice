package chapter3.test;

/**
 *      清单3.1  在没有同步的情况下共享变量(不要这样做)
 */

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while(!ready)
                Thread.yield();     //使当前线程从执行状态（运行状态）变为可执行态（就绪状态）
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
