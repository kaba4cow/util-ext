package com.kaba4cow.utilext.supplier;

import com.kaba4cow.utilext.cachedsupplier.CachedShortSupplier;

@FunctionalInterface
public interface ShortSupplier {

	short getAsShort();

	default CachedShortSupplier cache() {
		return new CachedShortSupplier(this);
	}

}
