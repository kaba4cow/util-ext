package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;

import com.kaba4cow.utilext.supplier.FloatSupplier;

public class CachedFloatSupplier implements FloatSupplier {

	private FloatSupplier supplier;
	private boolean present;
	private float value;

	public CachedFloatSupplier(FloatSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = 0.0f;
	}

	@Override
	public float getAsFloat() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsFloat();
		}
	}

	public CachedFloatSupplier remove() {
		present = false;
		return this;
	}

}
