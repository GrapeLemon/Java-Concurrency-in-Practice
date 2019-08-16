package chapter3;

import java.awt.*;
import java.util.EventListener;

/**
 *      隐式地允许this引用逸出(不要这样做)
 *
 *      这种发布对象和他的内部状态的机制是发布一个内部类实例，
 */

public class ThisEscape {
    public ThisEscape(EventSource source){
        source.registerListener(new EventListener() {
            public void onEvent(Event e){
                doSomething(e);
            }
        });
    }

    public void doSomething(Event e){}


}
