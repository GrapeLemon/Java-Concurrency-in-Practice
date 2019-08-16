package chapter3;

import annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

@ThreadSafe
public class VolatileCachedFactorizer implements Servlet {
    //这里的初始化感觉又有点东西了
    private volatile OneValueCache cache = new OneValueCache(null,null);


    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = cache.getFactors(i);
        if(factors == null){
            factors = factor(i);
            cache = new OneValueCache(i,factors);
            encodeIntoReponse(resp,factors);
        }
    }

    BigInteger extractFromRequest(ServletRequest req){
        return null;
    }

    BigInteger[] factor(BigInteger i){
        return null;
    }

    void encodeIntoReponse(ServletResponse resp,BigInteger[] factors){}






    public void init(ServletConfig servletConfig) throws ServletException {

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
