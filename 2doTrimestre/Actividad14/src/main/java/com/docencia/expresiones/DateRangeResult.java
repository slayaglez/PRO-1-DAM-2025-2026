package com.docencia.expresiones;

import java.time.LocalDate;

public record DateRangeResult(LocalDate start, LocalDate end, long totalDaysInclusive, int businessDaysInclusive) {}
