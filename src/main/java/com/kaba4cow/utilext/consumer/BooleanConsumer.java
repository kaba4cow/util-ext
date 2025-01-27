package com.kaba4cow.utilext.consumer;

import java.util.Objects;

@FunctionalInterface
public interface BooleanConsumer {

	void accept(boolean value);

	default BooleanConsumer andThen(BooleanConsumer after) {
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

}