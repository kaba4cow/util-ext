package com.kaba4cow.utilext.tobifunction;

@FunctionalInterface
public interface ToShortBiFunction<T, U> {

	short applyAsShort(T t, U u);

}
