package com.kaba4cow.utilext.supplier;

import com.kaba4cow.utilext.cachedsupplier.CachedFloatSupplier;

@FunctionalInterface
public interface FloatSupplier {

	float getAsFloat();

	default CachedFloatSupplier cache() {
		return new CachedFloatSupplier(this);
	}

}
