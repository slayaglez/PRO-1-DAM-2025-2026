package com.docencia.fechas.ejercicio15;

import org.junit.jupiter.api.Test;
import com.docencia.fechas.ProcessingPlan;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio15Test {

    @Test
    void nextProcessingPlanShouldScheduleSameDayWhenBeforeSlot() {
        ZoneId zone = ZoneId.of("Atlantic/Canary");
        ZonedDateTime received = ZonedDateTime.of(2026, 2, 10, 8, 0, 0, 0, zone);
        ProcessingPlan plan = Ejercicio15.nextProcessingPlan(received, zone, LocalTime.of(9, 0), LocalTime.of(18, 0));
        assertEquals(ZonedDateTime.of(2026, 2, 10, 9, 0, 0, 0, zone), plan.nextProcessing());
    }

    @Test
    void nextProcessingPlanShouldScheduleNextBusinessDayWhenAfterSlot() {
        ZoneId zone = ZoneId.of("Atlantic/Canary");
        ZonedDateTime received = ZonedDateTime.of(2026, 2, 10, 9, 0, 0, 0, zone);
        ProcessingPlan plan = Ejercicio15.nextProcessingPlan(received, zone, LocalTime.of(9, 0), LocalTime.of(18, 0));
        assertEquals(LocalDate.of(2026, 2, 11), plan.nextProcessing().toLocalDate());
    }

    @Test
    void nextProcessingPlanShouldScheduleNextBusinessDayWhenAfterCutoff() {
        ZoneId zone = ZoneId.of("Atlantic/Canary");
        ZonedDateTime received = ZonedDateTime.of(2026, 2, 10, 19, 0, 0, 0, zone);
        ProcessingPlan plan = Ejercicio15.nextProcessingPlan(received, zone, LocalTime.of(9, 0), LocalTime.of(18, 0));
        assertEquals(LocalDate.of(2026, 2, 11), plan.nextProcessing().toLocalDate());
    }

    @Test
    void nextProcessingPlanShouldSkipWeekend() {
        ZoneId zone = ZoneId.of("Atlantic/Canary");
        ZonedDateTime received = ZonedDateTime.of(2026, 2, 6, 19, 0, 0, 0, zone);
        ProcessingPlan plan = Ejercicio15.nextProcessingPlan(received, zone, LocalTime.of(9, 0), LocalTime.of(18, 0));
        assertEquals(DayOfWeek.MONDAY, plan.nextProcessing().getDayOfWeek());
    }

    @Test
    void nextProcessingPlanShouldThrowOnNullReceived() {
        assertThrows(NullPointerException.class, () -> Ejercicio15.nextProcessingPlan(null, ZoneId.of("UTC"), LocalTime.NOON, LocalTime.NOON));
    }
}
