package com.docencia.fechas.ejercicio9;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio9Test {

    @Test
    void canCancelWithin48hShouldBeTrueBeforeDeadline() {
        Instant purchase = Instant.parse("2026-02-10T10:00:00Z");
        assertTrue(Ejercicio9.canCancelWithin48h(purchase, purchase.plus(Duration.ofHours(47))));
    }

    @Test
    void canCancelWithin48hShouldBeTrueAtDeadline() {
        Instant purchase = Instant.parse("2026-02-10T10:00:00Z");
        assertTrue(Ejercicio9.canCancelWithin48h(purchase, purchase.plus(Duration.ofHours(48))));
    }

    @Test
    void canCancelWithin48hShouldBeFalseAfterDeadline() {
        Instant purchase = Instant.parse("2026-02-10T10:00:00Z");
        assertFalse(Ejercicio9.canCancelWithin48h(purchase, purchase.plus(Duration.ofHours(48)).plusSeconds(1)));
    }

    @Test
    void canCancelWithin48hShouldThrowOnNullPurchase() {
        assertThrows(NullPointerException.class, () -> Ejercicio9.canCancelWithin48h(null, Instant.now()));
    }

    @Test
    void canCancelWithin48hShouldThrowOnNullNow() {
        assertThrows(NullPointerException.class, () -> Ejercicio9.canCancelWithin48h(Instant.now(), null));
    }
}
