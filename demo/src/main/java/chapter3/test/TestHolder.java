package chapter3.test;

import chapter3.Holder;

public class TestHolder {
    Holder holder;
    public static void main(String[] args) {
        final TestHolder testHolder = new TestHolder();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                Holder holder = new Holder(1);
                while (true){
                    testHolder.holder = holder;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (true){
                    if(testHolder.holder == null){
                        System.out.println(Thread.currentThread() + "not available");
                    }else{
                        System.out.println(testHolder.holder.getN());
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();

    }
}
