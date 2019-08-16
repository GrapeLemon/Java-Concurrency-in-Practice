package chapter3;

import annotation.Immutable;
import annotation.Important;

import java.math.BigInteger;
import java.util.Arrays;

@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,BigInteger[] factors){
        lastNumber = i;
     /*
        为什么不这样写呢?
        lastFactors = factors;
        很明显这样写的话 lastFactors 就是可变的了
        如果返回的是拷贝的话,就可以确保 factors 的变化不会影响到 lastFactors
        好像突然理解了拷贝的作用，当拷贝和不可变性结合起来的时候，一切都是那么的合理！
      */
        lastFactors = Arrays.copyOf(factors,factors.length);

    }

    public BigInteger[] getFactors(BigInteger i){
        if(lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors,lastFactors.length);
    }
}
