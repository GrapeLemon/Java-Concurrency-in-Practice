package chapter3;

/**
 *      允许内部可变的数据溢出（不要这样做）
 */

public class UnsafeStates {
    private String[] states = new String[]{"AK","AL"};

    public String[] getStates() {return states;}
}
