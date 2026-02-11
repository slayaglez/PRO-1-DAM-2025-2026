package com.docencia.expresiones.ejercicio7;

import org.junit.jupiter.api.Test;
import com.docencia.expresiones.DateRangeResult;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio7Test {

    @Test
    void parseDateRangeShouldReturnCorrectTotals() {
        DateRangeResult r = Ejercicio7.parseDateRange("2026-02-09..2026-02-10");
        assertEquals(2L, r.totalDaysInclusive());
    }

    @Test
    void parseDateRangeShouldThrowOnNull() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio7.parseDateRange(null));
    }

    @Test
    void parseDateRangeShouldThrowOnBlank() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio7.parseDateRange(" "));
    }

    @Test
    void parseDateRangeShouldThrowOnWrongFormat() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio7.parseDateRange("2026-02-09/2026-02-10"));
    }

    @Test
    void parseDateRangeShouldThrowWhenEndBeforeStart() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio7.parseDateRange("2026-02-10..2026-02-09"));
    }
}
