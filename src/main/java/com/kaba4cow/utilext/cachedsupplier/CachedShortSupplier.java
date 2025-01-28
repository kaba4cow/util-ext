package com.kaba4cow.utilext.cachedsupplier;

import java.util.Objects;

import com.kaba4cow.utilext.supplier.ShortSupplier;

public class CachedShortSupplier implements ShortSupplier {

	private ShortSupplier supplier;
	private boolean present;
	private short value;

	public CachedShortSupplier(ShortSupplier supplier) {
		this.supplier = Objects.requireNonNull(supplier);
		this.present = false;
		this.value = 0;
	}

	@Override
	public short getAsShort() {
		if (present)
			return value;
		else {
			present = true;
			return value = supplier.getAsShort();
		}
	}

	public CachedShortSupplier remove() {
		present = false;
		return this;
	}

}
