package com.kaba4cow.utilext.consumer;

import java.util.Objects;

@FunctionalInterface
public interface FloatConsumer {

	void accept(float value);

	default FloatConsumer andThen(FloatConsumer after) {
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

}