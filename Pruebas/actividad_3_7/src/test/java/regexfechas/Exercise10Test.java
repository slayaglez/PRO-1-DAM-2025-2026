package regexfechas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Exercise10Test {

  @Test
  void t01_singleDate() {
    assertEquals(List.of("15/08/2024"), Exercise01.findAll("La fecha es 15/08/2024."));
  }

  @Test
  void t02_noDate() {
    assertEquals(List.of(), Exercise01.findAll("Sin fecha aquí."));
  }

  @Test
  void t03_twoDates() {
    assertEquals(List.of("01/01/2025","31/12/1999"), Exercise01.findAll("Dos: 01/01/2025 y 31/12/1999."));
  }

  @Test
  void t04_badShortFormat() {
    assertEquals(List.of(), Exercise01.findAll("Formato mal 1/1/2020."));
  }

  @Test
  void t05_wrongSeparatorDash() {
    assertEquals(List.of(), Exercise01.findAll("Separador 05-11-2023."));
  }

  @Test
  void t06_parenthesesBoundary() {
    assertEquals(List.of("05/11/2023"), Exercise01.findAll("Borde: (05/11/2023) ok."));
  }

  @Test
  void t07_embeddedInLettersNoBoundary() {
    assertEquals(List.of(), Exercise01.findAll("PegadoX05/11/2023Y"));
  }

  @Test
  void t08_startOfText() {
    assertEquals(List.of("05/11/2023"), Exercise01.findAll("05/11/2023 inicio"));
  }

  @Test
  void t09_endOfText() {
    assertEquals(List.of("05/11/2023"), Exercise01.findAll("fin 05/11/2023"));
  }

  @Test
  void t10_invalidDay00NotFound() {
    assertEquals(List.of(), Exercise01.findAll("00/12/2020 no debería salir."));
  }

  @Test
  void t11_invalidMonth13NotFound() {
    assertEquals(List.of(), Exercise01.findAll("31/13/2020 no debería salir."));
  }

  @Test
  void t12_leapDayFoundByRegex() {
    assertEquals(List.of("29/02/2024"), Exercise01.findAll("Texto 29/02/2024 ok para regex."));
  }

  @Test
  void t13_emptyString() {
    assertEquals(List.of(), Exercise01.findAll(""));
  }

  @Test
  void t14_nullString() {
    assertEquals(List.of(), Exercise01.findAll(null));
  }

  @Test
  void t15_multipleWithPunctuation() {
    assertEquals(List.of("10/10/2010","11/11/2011","12/12/2012"), Exercise01.findAll("Múltiples 10/10/2010, 11/11/2011; 12/12/2012."));
  }


}
