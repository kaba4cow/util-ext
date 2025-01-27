package com.kaba4cow.utilext.optional;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

import com.kaba4cow.utilext.consumer.ByteConsumer;
import com.kaba4cow.utilext.supplier.ByteSupplier;

public class OptionalByte {

	private static final OptionalByte EMPTY = new OptionalByte();

	private final boolean present;
	private final byte value;

	private OptionalByte() {
		this.present = false;
		this.value = 0;
	}

	private OptionalByte(byte value) {
		this.present = true;
		this.value = value;
	}

	public static OptionalByte empty() {
		return EMPTY;
	}

	public static OptionalByte of(byte value) {
		return new OptionalByte(value);
	}

	public byte getAsByte() {
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

	public void ifPresent(ByteConsumer action) {
		if (present)
			action.accept(value);
	}

	public void ifPresentOrElse(ByteConsumer action, Runnable emptyAction) {
		if (present)
			action.accept(value);
		else
			emptyAction.run();
	}

	public byte orElse(byte other) {
		return present ? value : other;
	}

	public byte orElseGet(ByteSupplier supplier) {
		return present ? value : supplier.getAsByte();
	}

	public byte orElseThrow() {
		if (!present)
			throw new NoSuchElementException("No value present");
		return value;
	}

	public <X extends Throwable> byte orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		if (present)
			return value;
		else
			throw exceptionSupplier.get();
	}

	@Override
	public int hashCode() {
		return present ? Byte.hashCode(value) : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionalByte other = (OptionalByte) obj;
		return (present && other.present) ? Byte.compare(value, other.value) == 0 : present == other.present;
	}

	@Override
	public String toString() {
		return present ? String.format("OptionalByte[%s]", value) : "OptionalByte.empty";
	}

}
