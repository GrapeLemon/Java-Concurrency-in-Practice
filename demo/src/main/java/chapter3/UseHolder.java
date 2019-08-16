package chapter3;

import annotation.NotThreadSafe;

@NotThreadSafe
public class UseHolder {
    //不安全发布
    public Holder holder;       //很显然定义为public 可以随便拿..

    public void initialize(){
        holder = new Holder(42);
    }
}
