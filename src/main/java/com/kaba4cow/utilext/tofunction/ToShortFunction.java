package com.kaba4cow.utilext.tofunction;

@FunctionalInterface
public interface ToShortFunction<T> {

	short applyAsShort(T value);

}
