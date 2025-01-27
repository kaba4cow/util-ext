package com.kaba4cow.utilext.tofunction;

@FunctionalInterface
public interface ToByteFunction<T> {

	byte applyAsByte(T value);

}
