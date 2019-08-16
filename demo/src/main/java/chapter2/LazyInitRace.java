package chapter2;

import annotation.NotThreadSafe;
import sun.security.jca.GetInstance;

/**
 *      清单2.3 惰性初始化中存在竞争条件(不要这样做)
 *      惰性初始化中存在竞争条件
 */

@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if(instance == null)
            instance = new ExpensiveObject();
        return instance;
    }
}



