package com.madingkoding.romanparser.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumeralParserTest {

	@ParameterizedTest(name = "{index} => romanNumerals={0}, expectedWholeNumner={1}")
	@CsvSource({ "CDLXXXVIII, 488", 
		         "DCCXXII, 722", 
		         "MCCLXV, 1265", 
		         "MCMXC, 1990", 
		         "MMXXXIX, 2039", 
		         "MMDCXIV, 2614",
			     "DCXXIV, 624", "DCCXXIV, 724", "XX, 20" })
	public void shouldConvertGivenRomanNumeralsIntoWholeNumbers(String romanNumerals, int expectedWholeNumner) {

		// Arrange

		// Act
		var actualWholeNumner = RomanNumeralParser.romanToInt(romanNumerals);

		// Assert
		assertThat(expectedWholeNumner).isEqualTo(actualWholeNumner);
	}

	@Test
	public void shouldThrowIllegalRomanNumeralExceptionWhenGivenIllegalRomanNumerals() {
		// Arrange
		var romanNumeral = "KAP";

		// Act
		var actualInvalidNumeralException = assertThrows(IllegalRomanNumeralException.class,
				() -> RomanNumeralParser.romanToInt(romanNumeral));

		// Assert
		assertThat(actualInvalidNumeralException.getMessage()).isEqualTo("KAP cannot be converted");
	}
}
