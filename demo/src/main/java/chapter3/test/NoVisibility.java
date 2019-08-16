package chapter3.test;

/**
 *      清单3.1  在没有同步的情况下共享变量(不要这样做)
 *      我多次运行也没有出现作者说的异常,但是只要有发生的可能性我们就不能这样做
 */

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while(!ready){
                System.out.println("not ready!");
                //Thread.yield();     //使当前线程从执行状态（运行状态）变为可执行态（就绪状态）
            }
                System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 412;
        ready = true;
    }
}
