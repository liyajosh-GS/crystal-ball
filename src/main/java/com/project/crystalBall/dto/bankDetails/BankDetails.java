package com.project.crystalBall.dto.bankDetails;

import com.project.crystalBall.dto.AbstractDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails extends AbstractDto {

    @NotNull
    private String accountNumber;

    @NotNull
    private String code;

    @NotNull
    private String accountHolder;

    @NotNull
    private String projectId;
}
