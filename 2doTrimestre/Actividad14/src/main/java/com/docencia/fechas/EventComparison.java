package com.docencia.fechas;

import java.time.Duration;
import java.time.ZonedDateTime;

public record EventComparison(ZonedDateTime first, ZonedDateTime second, Duration absoluteDifference) {}
