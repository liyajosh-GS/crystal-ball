package com.project.crystalBall.dto.project;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.Contribution;
import com.project.crystalBall.entity.project.FundingStatus;
import com.project.crystalBall.entity.project.ProjectType;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project extends AbstractDto {

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private List<String> creators;

    private List<Contribution> contributions;

    private FundingStatus fundingStatus;

    @NonNull
    private Double targetFund;

    @NonNull
    private ProjectType projectType;
}
