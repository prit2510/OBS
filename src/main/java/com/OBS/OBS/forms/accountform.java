package com.OBS.OBS.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class accountform {
    @NotBlank(message = "Account Number is required")
    @Size(min = 12,max = 12, message = "Invalid Account Number 10 Characters is required")
    private String accountNumber;
    @NotBlank(message = "account holder's name is required")
    private String accountHolderName;
    @Size(min = 4,max = 4, message = "Invalid pin 4 Characters is required")
    @NotBlank(message = "Account Pin is required")
    private int accountPin;
    @NotBlank(message = "Account Balance is required")
    private String accountBalance;

}
