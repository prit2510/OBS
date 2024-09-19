package com.OBS.OBS.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditForm {
     
    private String AccountNumber;
    @NotNull(message="Transaction Amount is required")
    private Double transactionAmount;
}
