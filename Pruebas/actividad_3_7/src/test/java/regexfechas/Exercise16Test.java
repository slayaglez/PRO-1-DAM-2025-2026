package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise16Test {

  @Test
  void t01_extractValid() {
   int[] res = Exercise07.extract("05/11/2023");

    assertArrayEquals(new int[]{5,11,2023}, res);
  }

  @Test
  void t02_extractYear0000() {
   int[] res = Exercise07.extract("01/01/0000");
    assertArrayEquals(new int[]{1,1,0}, res);
  }

  @Test
  void t03_extractEndYear() {
    int[] res = Exercise07.extract("31/12/1999");
    assertArrayEquals(new int[]{31,12,1999}, res);
  }

  @Test
  void t04_invalidDay00() {
    assertNull(Exercise07.extract("00/12/2020"));
  }

  @Test
  void t05_invalidDay32() {
    assertNull(Exercise07.extract("32/01/2020"));
  }

  @Test
  void t06_invalidMonth13() {
    assertNull(Exercise07.extract("15/13/2020"));
  }

  @Test
  void t07_notTwoDigitDay() {
    assertNull(Exercise07.extract("5/11/2023"));
  }

  @Test
  void t08_wrongSeparator() {
    assertNull(Exercise07.extract("05-11-2023"));
  }

  @Test
  void t09_twoDigitYearInvalid() {
    assertNull(Exercise07.extract("05/11/23"));
  }

  @Test
  void t10_leadingSpaceInvalid() {
    assertNull(Exercise07.extract(" 05/11/2023"));
  }

  @Test
  void t11_trailingSpaceInvalid() {
    assertNull(Exercise07.extract("05/11/2023 "));
  }

  @Test
  void t12_emptyString() {
    assertNull(Exercise07.extract(""));
  }

  @Test
  void t13_nullString() {
    assertNull(Exercise07.extract(null));
  }

  @Test
  void t14_extractLeapDay() {
   int[] res = Exercise07.extract("29/02/2024");
    assertNotNull(res);
    assertArrayEquals(new int[]{29,2,2024}, res);
  }

  @Test
  void t15_extractDoesNotValidateCalendar() {
   int[] res = Exercise07.extract("30/02/2024");
    assertNotNull(res);
    assertArrayEquals(new int[]{30,2,2024}, res);
  }


}
