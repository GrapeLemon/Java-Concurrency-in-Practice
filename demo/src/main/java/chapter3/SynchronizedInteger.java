package chapter3;

import annotation.GuardedBy;
import annotation.ThreadSafe;

/**
 *      清单3.3 现场安全的可变整数访问器
 */

@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this")  private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
