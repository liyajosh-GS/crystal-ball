package com.project.crystalBall.dto.contribution;

import com.project.crystalBall.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contribution extends AbstractDto {

    private Double amount;
    private Long projectId;
}
