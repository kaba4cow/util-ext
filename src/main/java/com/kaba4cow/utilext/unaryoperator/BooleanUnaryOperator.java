package com.kaba4cow.utilext.unaryoperator;

import java.util.Objects;

@FunctionalInterface
public interface BooleanUnaryOperator {

	boolean applyAsBoolean(boolean operand);

	default BooleanUnaryOperator compose(BooleanUnaryOperator before) {
		Objects.requireNonNull(before);
		return v -> applyAsBoolean(before.applyAsBoolean(v));
	}

	default BooleanUnaryOperator andThen(BooleanUnaryOperator after) {
		Objects.requireNonNull(after);
		return t -> after.applyAsBoolean(applyAsBoolean(t));
	}

	static BooleanUnaryOperator identity() {
		return t -> t;
	}

}
