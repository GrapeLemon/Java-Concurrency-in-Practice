package chapter1;

import annotation.GuardedBy;
import annotation.ThreadSafe;

/**
 *      清单1.2 线程安全的序列生成器
 */

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int value;

    public synchronized int getNext(){
        return value++;
    }
}
