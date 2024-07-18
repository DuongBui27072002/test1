package com.example.test1.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransictionHistoryDTO {
    @NotNull(message = "Transaction ID cannot be null")
    @Pattern(regexp = "\\d+", message = "Transaction ID must be a number")
    private Integer transactionId;

    @NotNull(message = "Account cannot be null")
    @Min(value = 1, message = "Account must be a positive number")
    private Integer account;

    @NotNull(message = "InDebt cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "InDebt must be greater than 0")
    private Double inDebt;

    @NotNull(message = "Have cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Have must be greater than 0")
    private Double have;

    @NotNull(message = "Time cannot be null")
    private LocalDate time;

}
