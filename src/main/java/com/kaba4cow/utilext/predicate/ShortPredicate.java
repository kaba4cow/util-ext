package com.kaba4cow.utilext.predicate;

import java.util.Objects;

@FunctionalInterface
public interface ShortPredicate {

	boolean test(short value);

	default ShortPredicate and(ShortPredicate other) {
		Objects.requireNonNull(other);
		return value -> test(value) && other.test(value);
	}

	default ShortPredicate negate() {
		return value -> !test(value);
	}

	default ShortPredicate or(ShortPredicate other) {
		Objects.requireNonNull(other);
		return value -> test(value) || other.test(value);
	}

}
