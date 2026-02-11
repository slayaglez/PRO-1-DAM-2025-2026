package com.docencia.fechas;

import java.time.Duration;
import java.time.ZonedDateTime;

public record ProcessingPlan(ZonedDateTime nextProcessing, Duration timeRemaining) {}
