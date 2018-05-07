package com.sample.basics;

import java.util.Date;

public class ImmutableObject {

	// Integer class is immutable as it does not provide any setter to change its content
	private final Integer immutableField1;
	// String class is immutable as it also does not provide setter to change its content
	private final String immutableField2;
	// Date class is mutable as it provide setters to change various date/time parts
	private final Date mutableField;

	//Default private constructor will ensure no unplanned construction of class
	private ImmutableObject(Integer fld1, String fld2, Date date) {
		this.immutableField1 = fld1;
		this.immutableField2 = fld2;
		this.mutableField = new Date(date.getTime());
	}

	// Integer class is immutable so we can return the instance variable as it is
	public Integer getImmutableField1() {
		return immutableField1;
	}

	// String class is also immutable so we can return the instance variable as it is
	public String getImmutableField2() {
		return immutableField2;
	}

	/**
	* Date class is mutable so we need a little care here.
	* We should not return the reference of original instance variable.
	* Instead a new Date object, with content copied to it, should be returned.
	* */
	public Date getMutableField() {
		return new Date(mutableField.getTime());
	}

	@Override
	public String toString() {
		return immutableField1 + " - " + immutableField2 + " - " + mutableField;
	}

	public static void main(String[] args) {
		ImmutableObject im = new ImmutableObject(100, "test", new Date());
		System.out.println(im);
		tryModification(im.getImmutableField1(), im.getImmutableField2(), im.getMutableField());
		System.out.println(im);
	}

	private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField) {
		immutableField1 = 10000;
		immutableField2 = "test changed";
		mutableField.setDate(10);
	}
}