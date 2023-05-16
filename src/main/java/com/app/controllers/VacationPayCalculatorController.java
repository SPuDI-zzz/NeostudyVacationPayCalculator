package com.app.controllers;

import com.app.service.VacationPayCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/calculate")
public class VacationPayCalculatorController {
    private final VacationPayCalculatorService vacationPayCalculatorService;

    @GetMapping
    public BigDecimal amountOfVacationPay(
            @Positive(message = "It must be positive value") BigDecimal averageSalary,
            @Positive(message = "It must be positive number") int vacationDays) {
        return vacationPayCalculatorService.calculateVacationPay(averageSalary, vacationDays);
    }
}
