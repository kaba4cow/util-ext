package com.kaba4cow.utilext.function;

@FunctionalInterface
public interface ByteFunction<R> {

	R apply(byte value);

}