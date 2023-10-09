package com.project.crystalBall.dto.contribution;

import com.project.crystalBall.dto.AbstractDto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contribution extends AbstractDto {
    @NonNull
    private Double amount;

    @NonNull
    private Long projectId;

    @NonNull
    private Long userId;
}
