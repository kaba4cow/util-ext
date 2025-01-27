package com.kaba4cow.utilext.optional;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import com.kaba4cow.utilext.consumer.ShortConsumer;
import com.kaba4cow.utilext.supplier.ShortSupplier;

public class OptionalShort {

	private static final OptionalShort EMPTY = new OptionalShort();

	private final boolean present;
	private final short value;

	private OptionalShort() {
		this.present = false;
		this.value = 0;
	}

	private OptionalShort(short value) {
		this.present = true;
		this.value = value;
	}

	public static OptionalShort empty() {
		return EMPTY;
	}

	public static OptionalShort of(short value) {
		return new OptionalShort(value);
	}

	public short getAsShort() {
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

	public void ifPresent(ShortConsumer action) {
		if (present)
			action.accept(value);
	}

	public void ifPresentOrElse(ShortConsumer action, Runnable emptyAction) {
		if (present)
			action.accept(value);
		else
			emptyAction.run();
	}

	public short orElse(short other) {
		return present ? value : other;
	}

	public short orElseGet(ShortSupplier supplier) {
		return present ? value : supplier.getAsShort();
	}

	public short orElseThrow() {
		if (!present)
			throw new NoSuchElementException("No value present");
		return value;
	}

	public <X extends Throwable> short orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		if (present)
			return value;
		else
			throw exceptionSupplier.get();
	}

	@Override
	public int hashCode() {
		return present ? Short.hashCode(value) : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionalShort other = (OptionalShort) obj;
		return (present && other.present) ? Short.compare(value, other.value) == 0 : present == other.present;
	}

	@Override
	public String toString() {
		return present ? String.format("OptionalShort[%s]", value) : "OptionalShort.empty";
	}

}
