package com.madingkoding.romanparser.model;

import lombok.Getter;

@Getter
public class IllegalRomanNumeralException extends RuntimeException {

	private final String romanNumeral;

	public IllegalRomanNumeralException(String romanNumeral) {
		super(romanNumeral + " cannot be converted");
		this.romanNumeral = romanNumeral;
	}
}
