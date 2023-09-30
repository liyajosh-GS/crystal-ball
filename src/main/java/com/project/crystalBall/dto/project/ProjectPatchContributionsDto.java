package com.project.crystalBall.dto.project;

import com.project.crystalBall.entity.Contribution;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPatchContributionsDto {

    @NonNull
    private List<Contribution> contributions;
}
