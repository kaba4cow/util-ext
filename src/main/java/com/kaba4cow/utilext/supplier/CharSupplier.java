package com.kaba4cow.utilext.supplier;

import com.kaba4cow.utilext.cachedsupplier.CachedCharSupplier;

@FunctionalInterface
public interface CharSupplier {

	char getAsChar();

	default CachedCharSupplier cache() {
		return new CachedCharSupplier(this);
	}

}
