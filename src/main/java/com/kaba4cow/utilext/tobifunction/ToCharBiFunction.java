package com.kaba4cow.utilext.tobifunction;

@FunctionalInterface
public interface ToCharBiFunction<T, U> {

	char applyAsChar(T t, U u);

}
