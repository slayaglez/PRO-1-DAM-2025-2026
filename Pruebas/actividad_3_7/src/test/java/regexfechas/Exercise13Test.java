package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise13Test {

  @Test
  void t01_valid() {
    assertTrue(Exercise04.isValid("01-01-2020"));
  }

  @Test
  void t02_validEndYear() {
    assertTrue(Exercise04.isValid("31-12-1999"));
  }

  @Test
  void t03_day00Invalid() {
    assertFalse(Exercise04.isValid("00-12-2020"));
  }

  @Test
  void t04_month00Invalid() {
    assertFalse(Exercise04.isValid("12-00-2020"));
  }

  @Test
  void t05_day32Invalid() {
    assertFalse(Exercise04.isValid("32-01-2020"));
  }

  @Test
  void t06_month13Invalid() {
    assertFalse(Exercise04.isValid("12-13-2020"));
  }

  @Test
  void t07_yearTwoDigitsInvalid() {
    assertFalse(Exercise04.isValid("12-12-20"));
  }

  @Test
  void t08_wrongSeparatorSlashes() {
    assertFalse(Exercise04.isValid("12/12/2020"));
  }

  @Test
  void t09_dayOneDigitInvalid() {
    assertFalse(Exercise04.isValid("1-12-2020"));
  }

  @Test
  void t10_monthOneDigitInvalid() {
    assertFalse(Exercise04.isValid("01-1-2020"));
  }

  @Test
  void t11_doubleDashesInvalid() {
    assertFalse(Exercise04.isValid("01--12--2020"));
  }

  @Test
  void t12_lettersInvalid() {
    assertFalse(Exercise04.isValid("aa-bb-cccc"));
  }

  @Test
  void t13_emptyString() {
    assertFalse(Exercise04.isValid(""));
  }

  @Test
  void t14_nullString() {
    assertFalse(Exercise04.isValid(null));
  }

  @Test
  void t15_leapDayFormatValid() {
    assertTrue(Exercise04.isValid("29-02-2024"));
  }


}
