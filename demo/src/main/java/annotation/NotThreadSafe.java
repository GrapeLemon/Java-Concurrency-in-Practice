package annotation;

/**
 *      非线程安全的  意味着在多线程环境下是不可用的,安全性无法得到保证
 *      同时意味着该代码是有害的，绝对不能被效仿
 */
public @interface NotThreadSafe {
}
