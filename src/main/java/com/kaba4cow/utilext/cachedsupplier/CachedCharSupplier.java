package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;

import com.kaba4cow.utilext.supplier.CharSupplier;

public class CachedCharSupplier implements CharSupplier {

	private CharSupplier supplier;
	private boolean present;
	private char value;

	public CachedCharSupplier(CharSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = 0;
	}

	@Override
	public char getAsChar() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsChar();
		}
	}

	public CachedCharSupplier remove() {
		present = false;
		return this;
	}

}
