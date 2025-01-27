package com.kaba4cow.utilext.unaryoperator;

import java.util.Objects;

@FunctionalInterface
public interface CharUnaryOperator {

	char applyAsChar(char operand);

	default CharUnaryOperator compose(CharUnaryOperator before) {
		Objects.requireNonNull(before);
		return v -> applyAsChar(before.applyAsChar(v));
	}

	default CharUnaryOperator andThen(CharUnaryOperator after) {
		Objects.requireNonNull(after);
		return t -> after.applyAsChar(applyAsChar(t));
	}

	static CharUnaryOperator identity() {
		return t -> t;
	}

}
