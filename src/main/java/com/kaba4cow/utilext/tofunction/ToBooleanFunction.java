package com.kaba4cow.utilext.tofunction;

@FunctionalInterface
public interface ToBooleanFunction<T> {

	boolean applyAsBoolean(T value);

}
