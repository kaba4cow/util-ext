package com.kaba4cow.utilext.predicate;

import java.util.Objects;

@FunctionalInterface
public interface BooleanPredicate {

	boolean test(boolean value);

	default BooleanPredicate and(BooleanPredicate other) {
		Objects.requireNonNull(other);
		return value -> test(value) && other.test(value);
	}

	default BooleanPredicate negate() {
		return value -> !test(value);
	}

	default BooleanPredicate or(BooleanPredicate other) {
		Objects.requireNonNull(other);
		return value -> test(value) || other.test(value);
	}

}
