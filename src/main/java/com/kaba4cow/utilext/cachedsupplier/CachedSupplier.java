package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;
import java.util.function.Supplier;

public class CachedSupplier<T> implements Supplier<T> {

	private final Supplier<T> supplier;
	private T value;

	public CachedSupplier(Supplier<T> supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.value = null;
	}

	@Override
	public T get() {
		return Objects.nonNull(value) ? value : (value = supplier.get());
	}

	public CachedSupplier<T> remove() {
		value = null;
		return this;
	}

}
