package com.OBS.OBS.forms;

import jakarta.validation.constraints.NotBlank;
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
   
    private Double transactionAmount;
    @NotBlank(message = "Sender's Account Number is required")
    private String FromAccountNumber;
    @NotBlank(message = "Receiver's Account Number is required")
    private String ToAccountNumber;
}
