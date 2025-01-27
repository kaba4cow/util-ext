package com.kaba4cow.utilext.consumer;

import java.util.Objects;

@FunctionalInterface
public interface CharConsumer {

	void accept(char value);

	default CharConsumer andThen(CharConsumer after) {
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

}