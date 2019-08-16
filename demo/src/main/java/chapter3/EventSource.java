package chapter3;

import java.util.EventListener;

public interface EventSource {
    void registerListener(EventListener eventListener);
}
