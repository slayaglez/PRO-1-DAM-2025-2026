package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise17Test {

  @Test
  void t01_validDecember() {
    assertTrue(Exercise08.isValid("01/12/2023"));
  }

  @Test
  void t02_validEndYear() {
    assertTrue(Exercise08.isValid("31/12/1999"));
  }

  @Test
  void t03_day00Invalid() {
    assertFalse(Exercise08.isValid("00/12/2020"));
  }

  @Test
  void t04_day32Invalid() {
    assertFalse(Exercise08.isValid("32/12/2020"));
  }

  @Test
  void t05_notDecemberInvalid() {
    assertFalse(Exercise08.isValid("15/11/2020"));
  }

  @Test
  void t06_notDecember2Invalid() {
    assertFalse(Exercise08.isValid("15/01/2020"));
  }

  @Test
  void t07_wrongSeparatorDash() {
    assertFalse(Exercise08.isValid("15-12-2020"));
  }

  @Test
  void t08_twoDigitYearInvalid() {
    assertFalse(Exercise08.isValid("15/12/20"));
  }

  @Test
  void t09_oneDigitDayInvalid() {
    assertFalse(Exercise08.isValid("5/12/2020"));
  }

  @Test
  void t10_validTwoDigitDay() {
    assertTrue(Exercise08.isValid("05/12/2020"));
  }

  @Test
  void t11_year0000Valid() {
    assertTrue(Exercise08.isValid("30/12/0000"));
  }

  @Test
  void t12_emptyString() {
    assertFalse(Exercise08.isValid(""));
  }

  @Test
  void t13_nullString() {
    assertFalse(Exercise08.isValid(null));
  }

  @Test
  void t14_validDecemberAnother() {
    assertTrue(Exercise08.isValid("29/12/2024"));
  }

  @Test
  void t15_invalidMonth13() {
    assertFalse(Exercise08.isValid("31/13/2024"));
  }


}
