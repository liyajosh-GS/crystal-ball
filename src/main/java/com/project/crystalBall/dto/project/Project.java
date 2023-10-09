package com.project.crystalball.dto.project;

import com.project.crystalball.dto.AbstractDto;
import com.project.crystalball.entity.project.ProjectType;
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
    private Long userId;

    @NonNull
    private Double targetFund;

    private Double collectedFund;

    @NonNull
    private ProjectType projectType;
}
