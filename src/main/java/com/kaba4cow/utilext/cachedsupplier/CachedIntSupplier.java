package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;
import java.util.function.IntSupplier;

public class CachedIntSupplier implements IntSupplier {

	private IntSupplier supplier;
	private boolean present;
	private int value;

	public CachedIntSupplier(IntSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = 0;
	}

	@Override
	public int getAsInt() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsInt();
		}
	}

	public CachedIntSupplier remove() {
		present = false;
		return this;
	}

}
