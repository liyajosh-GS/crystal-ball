package com.project.crystalball.dto.contribution;

import com.project.crystalball.dto.AbstractDto;
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
