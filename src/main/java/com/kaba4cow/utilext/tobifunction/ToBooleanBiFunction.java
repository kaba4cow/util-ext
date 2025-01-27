package com.kaba4cow.utilext.tobifunction;

@FunctionalInterface
public interface ToBooleanBiFunction<T, U> {

	boolean applyAsBoolean(T t, U u);

}
