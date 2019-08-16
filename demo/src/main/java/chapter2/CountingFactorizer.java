package chapter2;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 *      清单2.4 Servlet使用AtomicLong统计请求数
 */

public class CountingFactorizer implements Servlet {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount(){return count.get();}

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
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
