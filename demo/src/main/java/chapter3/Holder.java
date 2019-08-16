package chapter3;

import annotation.NotThreadSafe;
import annotation.Risky;

@Risky
public class Holder {
    private int n;

    /**
     *      可以看出，在构造函数中设置的域值，应该是向这些域写入的第一个值，因此，没有“更旧”的值可以作为所谓的过期值。
     *      但是Object的构造函数会先于子类的构造函数运行,并首先向所有域写入默认值。因此这些默认值可能成为域的过期值。
     *
     *      也就是说调用 Holder之前会先调用 Object,Object的构造函数会帮我们设置默认值！！原来这就是类的状态会初始化的原因
     *
     *      也就是说诡异的情况是这样发生的：
     *      1. A线程调用了构造函数 先创建了对象 分配了内存空间，准备将n的值设置为最终的状态前,中断
     *      2. B线程执行，拿到了这个对象的状态，但是由于A线程还没有赋值，拿到的是默认值0
     *      3. A线程完成赋值，但是已经为时已晚，B拿到的是默认值0，错误发生
     */
    public Holder(int n) {
        this.n = n;
    }

    //应该还要有这个
    public int getN() {
        return n;
    }

    //还是不太理解这个 assert的深意 应该是在多线程环境下使用的一种概念
    public void assertSanity(){
        if (n != n)     //这么简单的一行代码涉及到了两次读取
            throw  new AssertionError("This statement is false.");
    }

}
