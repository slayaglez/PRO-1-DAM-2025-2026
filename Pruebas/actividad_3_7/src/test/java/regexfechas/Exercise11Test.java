package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise11Test {

  @Test
  void t01_validLowercase() {
    assertTrue(Exercise02.isValid("12-marzo-2022"));
  }

  @Test
  void t02_validSingleDigitDay() {
    assertTrue(Exercise02.isValid("1-enero-2020"));
  }

  @Test
  void t03_validUppercase() {
    assertTrue(Exercise02.isValid("01-ENERO-2020"));
  }

  @Test
  void t04_validEndYear() {
    assertTrue(Exercise02.isValid("31-diciembre-1999"));
  }

  @Test
  void t05_invalidDay00() {
    assertFalse(Exercise02.isValid("00-marzo-2022"));
  }

  @Test
  void t06_invalidDay32() {
    assertFalse(Exercise02.isValid("32-marzo-2022"));
  }

  @Test
  void t07_invalidMonthText() {
    assertFalse(Exercise02.isValid("12-marz-2022"));
  }

  @Test
  void t08_invalidYearDigits() {
    assertFalse(Exercise02.isValid("12-marzo-22"));
  }

  @Test
  void t09_wrongFormatSlashes() {
    assertFalse(Exercise02.isValid("12/03/2022"));
  }

  @Test
  void t10_wrongSeparator() {
    assertFalse(Exercise02.isValid("12-marzo/2022"));
  }

  @Test
  void t11_setiembreAccepted() {
    assertTrue(Exercise02.isValid("12-setiembre-2022"));
  }

  @Test
  void t12_septiembreAccepted() {
    assertTrue(Exercise02.isValid("12-septiembre-2022"));
  }

  @Test
  void t13_year0000AllowedByRegex() {
    assertTrue(Exercise02.isValid("12-febrero-0000"));
  }

  @Test
  void t14_emptyString() {
    assertFalse(Exercise02.isValid(""));
  }

  @Test
  void t15_nullString() {
    assertFalse(Exercise02.isValid(null));
  }


}
