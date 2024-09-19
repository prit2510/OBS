package com.OBS.OBS.forms;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class withdrowForm {
     
    private String AccountNumber;
    @NotNull(message="Transaction Amount is required")
    private Double transactionAmount;
}
