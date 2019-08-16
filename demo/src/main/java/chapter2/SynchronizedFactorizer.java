package chapter2;

import annotation.GuardedBy;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *      缓存了最新结果的Servlet,单响应性令人无法接受(不要这样做)
 */

public class SynchronizedFactorizer implements Servlet {
   @GuardedBy("this")  private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
   @GuardedBy("this")  private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

    public synchronized void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
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
