package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise18Test {

  @Test
  void t01_twoDatesMixedSeparators() {
    assertEquals(List.of("05/11/2023","06-11-2023"), Exercise09.findAll("Fechas: 05/11/2023 y 06-11-2023."));
  }

  @Test
  void t02_singleDashDate() {
    assertEquals(List.of("31-12-1999"), Exercise09.findAll("Solo una: 31-12-1999"));
  }

  @Test
  void t03_noDate() {
    assertEquals(List.of(), Exercise09.findAll("Ninguna aqui."));
  }

  @Test
  void t04_mixedSeparatorsInvalid() {
    assertEquals(List.of(), Exercise09.findAll("Mixta 05/11-2023 no."));
  }

  @Test
  void t05_embeddedInLettersNoBoundary() {
    assertEquals(List.of(), Exercise09.findAll("PegadoA05/11/2023B"));
  }

  @Test
  void t06_startOfText() {
    assertEquals(List.of("05/11/2023"), Exercise09.findAll("05/11/2023."));
  }

  @Test
  void t07_endOfText() {
    assertEquals(List.of("05-11-2023"), Exercise09.findAll("... 05-11-2023"));
  }

  @Test
  void t08_parenthesesBoundary() {
    assertEquals(List.of("05-11-2023"), Exercise09.findAll("Con paréntesis (05-11-2023)."));
  }

  @Test
  void t09_day00NotFound() {
    assertEquals(List.of(), Exercise09.findAll("00/12/2020 no"));
  }

  @Test
  void t10_month13NotFound() {
    assertEquals(List.of(), Exercise09.findAll("31-13-2020 no"));
  }

  @Test
  void t11_threeDates() {
    assertEquals(List.of("01/01/2020","02-02-2021","03/03/2022"), Exercise09.findAll("Varios 01/01/2020, 02-02-2021, 03/03/2022"));
  }

  @Test
  void t12_emptyString() {
    assertEquals(List.of(), Exercise09.findAll(""));
  }

  @Test
  void t13_nullString() {
    assertEquals(List.of(), Exercise09.findAll(null));
  }

  @Test
  void t14_adjacentDatesSeparatedBySpace() {
    assertEquals(List.of("05/11/2023","06/11/2023"), Exercise09.findAll("05/11/2023 06/11/2023"));
  }

  @Test
  void t15_adjacentDatesSeparatedBySemicolon() {
    assertEquals(List.of("05-11-2023","06-11-2023"), Exercise09.findAll("05-11-2023;06-11-2023"));
  }


}
