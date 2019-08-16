package chapter2;

import annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 *      清单2.1 一个无状态的Servlet
 *      无状态对象永远是线程安全的
 */

@ThreadSafe
public class StatelessFactorizer implements Servlet {

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoReponse(resp,factors);
    }

    BigInteger extractFromRequest(ServletRequest req){
        return null;
    }

    BigInteger[] factor(BigInteger i){
        return null;
    }

    void encodeIntoReponse(ServletResponse resp,BigInteger[] factors){}

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
