package com.kaba4cow.utilext.function;

@FunctionalInterface
public interface BooleanFunction<R> {

	R apply(boolean value);

}