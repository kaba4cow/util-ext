package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;
import java.util.function.LongSupplier;

public class CachedLongSupplier implements LongSupplier {

	private LongSupplier supplier;
	private boolean present;
	private long value;

	public CachedLongSupplier(LongSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = 0L;
	}

	@Override
	public long getAsLong() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsLong();
		}
	}

	public CachedLongSupplier remove() {
		present = false;
		return this;
	}

}
