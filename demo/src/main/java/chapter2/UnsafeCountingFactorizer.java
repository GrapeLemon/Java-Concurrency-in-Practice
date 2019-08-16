package chapter2;

import annotation.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 *      清单2.2 Servlet计算请求数量而没有必要的同步(不要这样做)
 *
 *      在单线程的环境中运行良好
 *      在多线程环境下很容易  “遗失更新”
 *      这告诉我们不能假设你的程序只会在单线程跑而不去做并发控制，编写的任何程序都应该要假设会在多线程跑。
 *      而且，假设是在单线程环境下，写的并发控制的代码不会对性能有任何影响。
 *      但是在多线程环境下却可以保证线程安全
 */

@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {
    private long count = 0;

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
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
