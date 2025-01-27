package com.kaba4cow.utilext.binaryoperator;

@FunctionalInterface
public interface BooleanBinaryOperator {

	boolean applyAsBoolean(boolean left, boolean right);

}
