package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;

import com.kaba4cow.utilext.supplier.ByteSupplier;

public class CachedByteSupplier implements ByteSupplier {

	private ByteSupplier supplier;
	private boolean present;
	private byte value;

	public CachedByteSupplier(ByteSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = 0;
	}

	@Override
	public byte getAsByte() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsByte();
		}
	}

	public CachedByteSupplier remove() {
		present = false;
		return this;
	}

}
