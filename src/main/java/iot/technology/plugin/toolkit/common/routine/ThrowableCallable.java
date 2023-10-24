package iot.technology.plugin.toolkit.common.routine;

import com.intellij.util.ThrowableRunnable;

/**
 * @author mushuwei
 */
@FunctionalInterface
public interface ThrowableCallable <R, E extends Throwable> {

    R call() throws E;

    static <E extends Throwable> ThrowableCallable<?, E> from(ThrowableRunnable<E> runnable) {
        return (ThrowableCallable<Object, E>) () -> {
            runnable.run();
            return null;
        };
    }
}
