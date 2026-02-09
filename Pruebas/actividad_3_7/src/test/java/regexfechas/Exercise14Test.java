package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise14Test {

  @Test
  void t01_validSingleDigits() {
    assertTrue(Exercise05.isValid("5/7/2023"));
  }

  @Test
  void t02_validTwoDigits() {
    assertTrue(Exercise05.isValid("05/07/2023"));
  }

  @Test
  void t03_validEndYear() {
    assertTrue(Exercise05.isValid("31/12/1999"));
  }

  @Test
  void t04_dayZeroInvalid() {
    assertFalse(Exercise05.isValid("0/7/2023"));
  }

  @Test
  void t05_day32Invalid() {
    assertFalse(Exercise05.isValid("32/1/2023"));
  }

  @Test
  void t06_month13Invalid() {
    assertFalse(Exercise05.isValid("31/13/2023"));
  }

  @Test
  void t07_month0Invalid() {
    assertFalse(Exercise05.isValid("31/0/2023"));
  }

  @Test
  void t08_wrongSeparator() {
    assertFalse(Exercise05.isValid("5-7-2023"));
  }

  @Test
  void t09_yearTwoDigitsInvalid() {
    assertFalse(Exercise05.isValid("5/07/23"));
  }

  @Test
  void t10_yearThreeDigitsInvalid() {
    assertFalse(Exercise05.isValid("05/7/202"));
  }

  @Test
  void t11_doubleSlashInvalid() {
    assertFalse(Exercise05.isValid("05//7/2023"));
  }

  @Test
  void t12_trailingSpaceInvalid() {
    assertFalse(Exercise05.isValid("05/07/2023 "));
  }

  @Test
  void t13_emptyString() {
    assertFalse(Exercise05.isValid(""));
  }

  @Test
  void t14_nullString() {
    assertFalse(Exercise05.isValid(null));
  }

  @Test
  void t15_leapDayFormatValid() {
    assertTrue(Exercise05.isValid("29/2/2024"));
  }


}
