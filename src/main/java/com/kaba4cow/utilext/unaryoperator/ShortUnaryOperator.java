package com.kaba4cow.utilext.unaryoperator;

import java.util.Objects;

@FunctionalInterface
public interface ShortUnaryOperator {

	short applyAsShort(short operand);

	default ShortUnaryOperator compose(ShortUnaryOperator before) {
		Objects.requireNonNull(before);
		return v -> applyAsShort(before.applyAsShort(v));
	}

	default ShortUnaryOperator andThen(ShortUnaryOperator after) {
		Objects.requireNonNull(after);
		return t -> after.applyAsShort(applyAsShort(t));
	}

	static ShortUnaryOperator identity() {
		return t -> t;
	}

}
