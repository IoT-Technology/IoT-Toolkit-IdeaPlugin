package iot.technology.plugin.toolkit.common.routine;

@FunctionalInterface
public interface ParametricCallable<P, R, E extends Throwable> {
    R call(P param) throws E;
}
