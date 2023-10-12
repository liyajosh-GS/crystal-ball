package com.project.crystalBall.dto.project;

import com.project.crystalBall.dto.AbstractDto;
import com.project.crystalBall.entity.project.ProjectType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project extends AbstractDto {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private List<String> groupMembers;

    @NotNull
    private Long userId;

    @NotNull
    private Double targetFund;

    private Double collectedFund;

    @NotNull
    private ProjectType projectType;
}
