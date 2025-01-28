package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;
import java.util.function.DoubleSupplier;

public class CachedDoubleSupplier implements DoubleSupplier {

	private DoubleSupplier supplier;
	private boolean present;
	private double value;

	public CachedDoubleSupplier(DoubleSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = 0;
	}

	@Override
	public double getAsDouble() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsDouble();
		}
	}

	public CachedDoubleSupplier remove() {
		present = false;
		return this;
	}

}
