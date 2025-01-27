package com.kaba4cow.utilext.tofunction;

@FunctionalInterface
public interface ToFloatFunction<T> {

	float applyAsFloat(T value);

}
