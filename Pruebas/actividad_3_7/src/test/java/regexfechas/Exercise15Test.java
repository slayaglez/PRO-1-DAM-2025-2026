package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise15Test {

  @Test
  void t01_dateOnlyValid() {
    assertTrue(Exercise06.isValid("10/10/2023"));
  }

  @Test
  void t02_withTimeValid() {
    assertTrue(Exercise06.isValid("10/10/2023 14:30"));
  }

  @Test
  void t03_midnightValid() {
    assertTrue(Exercise06.isValid("10/10/2023 00:00"));
  }

  @Test
  void t04_lastMinuteValid() {
    assertTrue(Exercise06.isValid("10/10/2023 23:59"));
  }

  @Test
  void t05_hour24Invalid() {
    assertFalse(Exercise06.isValid("10/10/2023 24:00"));
  }

  @Test
  void t06_minute60Invalid() {
    assertFalse(Exercise06.isValid("10/10/2023 12:60"));
  }

  @Test
  void t07_hourOneDigitInvalid() {
    assertFalse(Exercise06.isValid("10/10/2023 7:05"));
  }

  @Test
  void t08_minuteOneDigitInvalid() {
    assertFalse(Exercise06.isValid("10/10/2023 07:5"));
  }

  @Test
  void t09_TSeparatorInvalid() {
    assertFalse(Exercise06.isValid("10/10/2023T14:30"));
  }

  @Test
  void t10_wrongDateSeparatorInvalid() {
    assertFalse(Exercise06.isValid("10-10-2023 14:30"));
  }

  @Test
  void t11_day00Invalid() {
    assertFalse(Exercise06.isValid("00/10/2023 14:30"));
  }

  @Test
  void t12_day32Invalid() {
    assertFalse(Exercise06.isValid("32/10/2023"));
  }

  @Test
  void t13_emptyString() {
    assertFalse(Exercise06.isValid(""));
  }

  @Test
  void t14_nullString() {
    assertFalse(Exercise06.isValid(null));
  }

  @Test
  void t15_year0000WithTimeValid() {
    assertTrue(Exercise06.isValid("01/01/0000 01:01"));
  }


}
