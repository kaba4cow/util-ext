package com.kaba4cow.utilext.consumer;

import java.util.Objects;

@FunctionalInterface
public interface ShortConsumer {

	void accept(short value);

	default ShortConsumer andThen(ShortConsumer after) {
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

}