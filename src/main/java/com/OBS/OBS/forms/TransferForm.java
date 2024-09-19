package com.OBS.OBS.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TransferForm {
    
    @NotNull(message="Transaction Amount is required")
    private Double transactionAmount;
    private String FromAccountNumber;
    @NotBlank(message = "Receiver's Account Number is required")
    private String ToAccountNumber;
}
