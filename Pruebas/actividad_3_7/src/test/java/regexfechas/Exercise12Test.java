package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise12Test {

  @Test
  void t01_minYear() {
    assertTrue(Exercise03.isValid("01/01/1900"));
  }

  @Test
  void t02_maxYear() {
    assertTrue(Exercise03.isValid("31/12/2099"));
  }

  @Test
  void t03_midYearValid() {
    assertTrue(Exercise03.isValid("15/08/1999"));
  }

  @Test
  void t04_year2100Invalid() {
    assertFalse(Exercise03.isValid("15/08/2100"));
  }

  @Test
  void t05_year1899Invalid() {
    assertFalse(Exercise03.isValid("15/08/1899"));
  }

  @Test
  void t06_day00Invalid() {
    assertFalse(Exercise03.isValid("00/12/2000"));
  }

  @Test
  void t07_day32Invalid() {
    assertFalse(Exercise03.isValid("32/01/2000"));
  }

  @Test
  void t08_month13Invalid() {
    assertFalse(Exercise03.isValid("15/13/2000"));
  }

  @Test
  void t09_month00Invalid() {
    assertFalse(Exercise03.isValid("15/00/2000"));
  }

  @Test
  void t10_dayNotTwoDigits() {
    assertFalse(Exercise03.isValid("5/07/2000"));
  }

  @Test
  void t11_monthNotTwoDigits() {
    assertFalse(Exercise03.isValid("05/7/2000"));
  }

  @Test
  void t12_wrongSeparator() {
    assertFalse(Exercise03.isValid("05-07-2000"));
  }

  @Test
  void t13_emptyString() {
    assertFalse(Exercise03.isValid(""));
  }

  @Test
  void t14_nullString() {
    assertFalse(Exercise03.isValid(null));
  }

  @Test
  void t15_leapDayFormatValid() {
    assertTrue(Exercise03.isValid("29/02/2004"));
  }


}
