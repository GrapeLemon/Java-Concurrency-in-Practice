package chapter2;

import annotation.GuardedBy;
import annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *    清单2.8 缓存最新请求和结果的servlet
 */

@ThreadSafe
public class CachedFactorizer implements Servlet {
    @GuardedBy("this")  private  BigInteger lastNumber;
    @GuardedBy("this")  private  BigInteger[] lastFactors;
    @GuardedBy("this")  private long hits;          //总次数
    @GuardedBy("this")  private long cacheHits;     //命中缓存次数

    public synchronized long getHits(){return  hits; }
    public synchronized double getCacheHitRatio(){
        return (double) cacheHits / (double)hits;
    }

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this){
            ++ hits;
            if(i.equals(lastNumber)){
                ++ cacheHits;
                /**
                 *   这个clone就很讲究，这样写的话我们的状态就指向了一个不会变的东西
                 *   如果是写成:
                 *   factors = lastFactors;
                 *   这样的话,lastFactors变,factors也会变
                 *   但是这样写的话:
                 *   factors = lastFactors.clone();
                 *   lastFactors变,factors也不会受到影响
                 */
                factors = lastFactors.clone();
            }
        }
        if(factors == null){
            factors = factor(i);
            synchronized (this){
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        encodeIntoReponse(resp,factors);
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
