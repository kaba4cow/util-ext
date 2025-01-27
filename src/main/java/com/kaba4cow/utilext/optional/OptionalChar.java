package com.kaba4cow.utilext.optional;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import com.kaba4cow.utilext.consumer.CharConsumer;
import com.kaba4cow.utilext.supplier.CharSupplier;

public class OptionalChar {

	private static final OptionalChar EMPTY = new OptionalChar();

	private final boolean present;
	private final char value;

	private OptionalChar() {
		this.present = false;
		this.value = 0;
	}

	private OptionalChar(char value) {
		this.present = true;
		this.value = value;
	}

	public static OptionalChar empty() {
		return EMPTY;
	}

	public static OptionalChar of(char value) {
		return new OptionalChar(value);
	}

	public char getAsCharacter() {
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

	public void ifPresent(CharConsumer action) {
		if (present)
			action.accept(value);
	}

	public void ifPresentOrElse(CharConsumer action, Runnable emptyAction) {
		if (present)
			action.accept(value);
		else
			emptyAction.run();
	}

	public char orElse(char other) {
		return present ? value : other;
	}

	public char orElseGet(CharSupplier supplier) {
		return present ? value : supplier.getAsChar();
	}

	public char orElseThrow() {
		if (!present)
			throw new NoSuchElementException("No value present");
		return value;
	}

	public <X extends Throwable> char orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		if (present)
			return value;
		else
			throw exceptionSupplier.get();
	}

	@Override
	public int hashCode() {
		return present ? Character.hashCode(value) : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionalChar other = (OptionalChar) obj;
		return (present && other.present) ? Character.compare(value, other.value) == 0 : present == other.present;
	}

	@Override
	public String toString() {
		return present ? String.format("OptionalChar[%s]", value) : "OptionalChar.empty";
	}

}
