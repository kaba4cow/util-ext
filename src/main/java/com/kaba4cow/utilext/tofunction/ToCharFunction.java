package com.kaba4cow.utilext.tofunction;

@FunctionalInterface
public interface ToCharFunction<T> {

	char applyAsChar(T value);

}
