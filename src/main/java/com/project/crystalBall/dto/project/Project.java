package com.project.crystalBall.dto.project;

import com.project.crystalBall.dto.AbstractDto;
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

    @NonNull
    private Double targetFund;

    private Double collectedFund;

    @NonNull
    private ProjectType projectType;
}
