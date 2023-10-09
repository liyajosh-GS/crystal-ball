package com.project.crystalball.dto.project;

import com.project.crystalball.dto.contribution.Contribution;
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
