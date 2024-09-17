package com.OBS.OBS.forms;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditForm {
     @NotBlank(message = "Account Number is required")
    private String AccountNumber;
    private Double transactionAmount;
}
