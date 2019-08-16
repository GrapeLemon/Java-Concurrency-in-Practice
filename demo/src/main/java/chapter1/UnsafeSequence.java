package chapter1;

import annotation.NotThreadSafe;

/**
 *      清单1.1 非线程安全的序列生成器
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    //返回一个唯一值
    public int getNext(){
    return value++;     //读-改-写，多线程环境下读的vaule极有可能不是最新值。
    }
}
