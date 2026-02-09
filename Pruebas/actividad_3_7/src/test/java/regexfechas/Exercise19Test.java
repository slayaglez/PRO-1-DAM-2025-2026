package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise19Test {

  @Test
  void t01_year2000Valid() {
    assertTrue(Exercise10.isValid("01/01/2000"));
  }

  @Test
  void t02_year2099Valid() {
    assertTrue(Exercise10.isValid("31/12/2099"));
  }

  @Test
  void t03_year1999Invalid() {
    assertFalse(Exercise10.isValid("15/08/1999"));
  }

  @Test
  void t04_year1900Invalid() {
    assertFalse(Exercise10.isValid("15/08/1900"));
  }

  @Test
  void t05_year2100Invalid() {
    assertFalse(Exercise10.isValid("15/08/2100"));
  }

  @Test
  void t06_day00Invalid() {
    assertFalse(Exercise10.isValid("00/12/2000"));
  }

  @Test
  void t07_day32Invalid() {
    assertFalse(Exercise10.isValid("32/01/2000"));
  }

  @Test
  void t08_month13Invalid() {
    assertFalse(Exercise10.isValid("15/13/2000"));
  }

  @Test
  void t09_month00Invalid() {
    assertFalse(Exercise10.isValid("15/00/2000"));
  }

  @Test
  void t10_regularValid() {
    assertTrue(Exercise10.isValid("05/11/2023"));
  }

  @Test
  void t11_twoDigitYearInvalid() {
    assertFalse(Exercise10.isValid("05/11/23"));
  }

  @Test
  void t12_wrongSeparatorInvalid() {
    assertFalse(Exercise10.isValid("05-11-2023"));
  }

  @Test
  void t13_emptyString() {
    assertFalse(Exercise10.isValid(""));
  }

  @Test
  void t14_nullString() {
    assertFalse(Exercise10.isValid(null));
  }

  @Test
  void t15_leapDayFormatValid() {
    assertTrue(Exercise10.isValid("29/02/2004"));
  }


}
