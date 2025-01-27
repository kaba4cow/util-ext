package com.kaba4cow.utilext.optional;

import java.util.NoSuchElementException;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import com.kaba4cow.utilext.consumer.BooleanConsumer;

public class OptionalBoolean {

	private static final OptionalBoolean EMPTY = new OptionalBoolean();

	private final boolean present;
	private final boolean value;

	private OptionalBoolean() {
		this.present = false;
		this.value = false;
	}

	private OptionalBoolean(boolean value) {
		this.present = true;
		this.value = value;
	}

	public static OptionalBoolean empty() {
		return EMPTY;
	}

	public static OptionalBoolean of(boolean value) {
		return new OptionalBoolean(value);
	}

	public boolean getAsBoolean() {
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

	public void ifPresent(BooleanConsumer action) {
		if (present)
			action.accept(value);
	}

	public void ifPresentOrElse(BooleanConsumer action, Runnable emptyAction) {
		if (present)
			action.accept(value);
		else
			emptyAction.run();
	}

	public boolean orElse(boolean other) {
		return present ? value : other;
	}

	public boolean orElseGet(BooleanSupplier supplier) {
		return present ? value : supplier.getAsBoolean();
	}

	public boolean orElseThrow() {
		if (!present)
			throw new NoSuchElementException("No value present");
		return value;
	}

	public <X extends Throwable> boolean orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		if (present)
			return value;
		else
			throw exceptionSupplier.get();
	}

	@Override
	public int hashCode() {
		return present ? Boolean.hashCode(value) : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionalBoolean other = (OptionalBoolean) obj;
		return (present && other.present) ? Boolean.compare(value, other.value) == 0 : present == other.present;
	}

	@Override
	public String toString() {
		return present ? String.format("OptionalBoolean[%s]", value) : "OptionalBoolean.empty";
	}

}
