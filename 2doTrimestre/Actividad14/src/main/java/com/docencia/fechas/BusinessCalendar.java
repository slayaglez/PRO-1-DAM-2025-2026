package com.docencia.fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public final class BusinessCalendar {

    private BusinessCalendar() {}

    public static boolean isBusinessDay(LocalDate date) {
         return false;
    }

    public static int countBusinessDaysInclusive(LocalDate start, LocalDate end) {
         return 0;
    }

    public static LocalDate addBusinessDays(LocalDate start, int n) {
         return null;
    }
}
