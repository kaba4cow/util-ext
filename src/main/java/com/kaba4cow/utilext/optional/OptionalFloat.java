package com.kaba4cow.utilext.optional;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import com.kaba4cow.utilext.consumer.FloatConsumer;
import com.kaba4cow.utilext.supplier.FloatSupplier;

public class OptionalFloat {

	private static final OptionalFloat EMPTY = new OptionalFloat();

	private final boolean present;
	private final float value;

	private OptionalFloat() {
		this.present = false;
		this.value = 0.0f;
	}

	private OptionalFloat(float value) {
		this.present = true;
		this.value = value;
	}

	public static OptionalFloat empty() {
		return EMPTY;
	}

	public static OptionalFloat of(float value) {
		return new OptionalFloat(value);
	}

	public float getAsFloat() {
		if (!present)
			throw new NoSuchElementException("No value present");
		return value;
	}

	public boolean isPresent() {
		return present;
	}

	public boolean isEmpty() {
		return !present;
	}

	public void ifPresent(FloatConsumer action) {
		if (present)
			action.accept(value);
	}

	public void ifPresentOrElse(FloatConsumer action, Runnable emptyAction) {
		if (present)
			action.accept(value);
		else
			emptyAction.run();
	}

	public float orElse(float other) {
		return present ? value : other;
	}

	public float orElseGet(FloatSupplier supplier) {
		return present ? value : supplier.getAsFloat();
	}

	public float orElseThrow() {
		if (!present)
			throw new NoSuchElementException("No value present");
		return value;
	}

	public <X extends Throwable> float orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		if (present)
			return value;
		else
			throw exceptionSupplier.get();
	}

	@Override
	public int hashCode() {
		return present ? Float.hashCode(value) : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionalFloat other = (OptionalFloat) obj;
		return (present && other.present) ? Float.compare(value, other.value) == 0 : present == other.present;
	}

	@Override
	public String toString() {
		return present ? String.format("OptionalFloat[%s]", value) : "OptionalFloat.empty";
	}

}
