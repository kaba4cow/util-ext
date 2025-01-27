package com.kaba4cow.utilext.tobifunction;

@FunctionalInterface
public interface ToByteBiFunction<T, U> {

	byte applyAsByte(T t, U u);

}
