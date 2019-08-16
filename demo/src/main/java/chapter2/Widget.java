package chapter2;

/**
 *      清单2.7 如果内部锁不是可重入的，代码将死锁
 */

public class Widget {
    public synchronized void doSomething(){

    }
}

class LoggingWidget extends Widget {
    public synchronized void doSomething(){
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}