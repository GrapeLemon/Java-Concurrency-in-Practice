package chapter3;

import annotation.NotThreadSafe;

/**
 *     清单3.2 非线程安全的可变整数访问器
 */

@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get(){return value;}
    public void set(int value){this.value = value;}
}
