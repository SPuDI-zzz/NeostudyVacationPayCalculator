package com.app.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationPayCalculatorService {
    public static final BigDecimal AVERAGE_DAYS_PER_MONTH = BigDecimal.valueOf(29.3);
    public static final int SCALE = 10;
    public static final int NEW_SCALE = 2;

    public BigDecimal calculateVacationPay(BigDecimal averageSalary, int vacationDays) {
        BigDecimal vacationPayPerDay = averageSalary.divide(AVERAGE_DAYS_PER_MONTH, SCALE, RoundingMode.DOWN);
        return vacationPayPerDay.multiply(BigDecimal.valueOf(vacationDays)).setScale(NEW_SCALE, RoundingMode.DOWN);
    }
}
