package com.kaba4cow.utilext.tobifunction;

@FunctionalInterface
public interface ToFloatBiFunction<T, U> {

	float applyAsFloat(T t, U u);

}
