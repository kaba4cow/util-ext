package com.kaba4cow.utilext.supplier;

import com.kaba4cow.utilext.cachedsupplier.CachedByteSupplier;

@FunctionalInterface
public interface ByteSupplier {

	byte getAsByte();

	default CachedByteSupplier cache() {
		return new CachedByteSupplier(this);
	}

}
