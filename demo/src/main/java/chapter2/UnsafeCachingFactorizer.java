package chapter2;

import annotation.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *      清单2.5 没有正确原子化的 Servlet 试图缓存它的最新结果(不要这样做)
 *
 *      非线程安全的原因：虽然使用了原子变量，但是这两个相互关联的状态变量的更新操作不是单一的原子操作。
 */

@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if(i.equals(lastNumber.get()))                      //假设要输入跟缓存中key的一致
            encodeIntoReponse(resp, lastFactors.get());     //直接返回缓存中的value
        else{                                               //否则重新计算并将这对 key-value放入缓存中
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoReponse(resp,factors);
        }
    }

    BigInteger extractFromRequest(ServletRequest req){
        return null;
    }

    BigInteger[] factor(BigInteger i){
        return null;
    }

    void encodeIntoReponse(ServletResponse resp, BigInteger[] factors){}

    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
