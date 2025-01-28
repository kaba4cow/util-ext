package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class CachedBooleanSupplier implements BooleanSupplier {

	private BooleanSupplier supplier;
	private boolean present;
	private boolean value;

	public CachedBooleanSupplier(BooleanSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = false;
	}

	@Override
	public boolean getAsBoolean() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsBoolean();
		}
	}

	public CachedBooleanSupplier remove() {
		present = false;
		return this;
	}

}
