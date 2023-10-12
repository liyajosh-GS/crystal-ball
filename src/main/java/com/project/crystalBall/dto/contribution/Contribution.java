package com.project.crystalBall.dto.contribution;

import com.project.crystalBall.dto.AbstractDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contribution extends AbstractDto {
    @NotNull
    private Double amount;

    @NotNull
    private Long projectId;

    @NotNull
    private Long userId;
}
