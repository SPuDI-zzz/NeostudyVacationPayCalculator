package com.app.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertSame;

@ExtendWith(MockitoExtension.class)
public class VacationPayCalculatorServiceTest {
    @Mock
    private VacationPayCalculatorService vacationPayCalculatorService;

    public static final int VACATION_DAYS = 14;
    public static final BigDecimal AVERAGE_DAYS_PER_MONTH = BigDecimal.valueOf(29.3);
    public static final int SCALE = 10;
    public static final int NEW_SCALE = 2;
    public static final BigDecimal AVERAGE_SALARY = BigDecimal.valueOf(50000);

    @Test
    public void calculateVacationPayTest() {
        BigDecimal vacationPayPerDay = AVERAGE_SALARY.divide(AVERAGE_DAYS_PER_MONTH, SCALE, RoundingMode.DOWN);
        BigDecimal vacationPay = vacationPayPerDay
                .multiply(BigDecimal.valueOf(VACATION_DAYS))
                .setScale(NEW_SCALE, RoundingMode.DOWN);

        Mockito.when(vacationPayCalculatorService.calculateVacationPay(AVERAGE_SALARY, VACATION_DAYS)).thenReturn(vacationPay);
        BigDecimal resultVacationPay = vacationPayCalculatorService.calculateVacationPay(AVERAGE_SALARY, VACATION_DAYS);
        assertSame(vacationPay,resultVacationPay);
    }
}
