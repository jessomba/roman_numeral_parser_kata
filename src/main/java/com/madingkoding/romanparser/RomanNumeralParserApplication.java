package com.madingkoding.romanparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.madingkoding.romanparser.model.RomanNumeralParser;

public class RomanNumeralParserApplication {
	private static final Logger LOGGER = LogManager.getLogger(RomanNumeralParserApplication.class);

	public static void main(String[] args) {
		String romanNumeral = "MMXXII";
		LOGGER.info("-----------Parsing started-----------");
		int wholeNumber = RomanNumeralParser.romanToInt(romanNumeral);
		LOGGER.info(() -> String.format("%s Succesfully coverted in %d", romanNumeral, wholeNumber));
		LOGGER.info("-----------Parsing terminated-----------");
	}
}
