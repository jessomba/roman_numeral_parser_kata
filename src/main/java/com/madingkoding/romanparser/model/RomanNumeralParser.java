package com.madingkoding.romanparser.model;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class RomanNumeralParser {

	private RomanNumeralParser() {

	}


	/**
	 *  <h1>Algorithm :</h1>
	 * 
	 * 
	 * LET numeral be the input String representing an Roman Numeral 
	 * LET symbol be initially set to RomanNumeral.values()[0] 
	 * WHILE numeral.length > 0: 
	 *    IF numeral starts with symbol's name: 
	 *         add symbol's value to the result 
	 *         remove the symbol's name from the numeral's beginning 
	 *    ELSE: 
	 *         set symbol to the next symbol
	 */
	private static final Logger LOGGER = LogManager.getLogger(RomanNumeralParser.class);

	public static int romanToInt(String input) {
		String romanNumeral = input.toUpperCase();
		int result = 0;

		List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

		int i = 0;

		while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
			RomanNumeral symbol = romanNumerals.get(i);
			if (romanNumeral.startsWith(symbol.name())) {
				result += symbol.getValue();
				romanNumeral = romanNumeral.substring(symbol.name().length());
			} else {
				i++;
			}
		}

		// Roman numeral cannot be converted to whole number
		if (romanNumeral.length() > 0) {
			throw new IllegalRomanNumeralException(input);
		}
		LOGGER.info(() -> String.format("%s Succesfully parsed", input));
		return result;
	}
}
