package com.project.crystalBall.entity.project;

import com.project.crystalBall.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ProjectEntity.TABLE_NAME)
public class ProjectEntity extends AbstractEntity {
    public static final String TABLE_NAME = "project";

    @Column(name = "name", length=50, nullable=false)
    private String name;

    @Column(name = "description", nullable=false)
    private String description;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "group_members", nullable=false)
    private List<String> groupMembers;

    @Column(name = "is_archived")
    private Boolean isArchived;

    @Column(name = "target_fund", nullable=false)
    private Double targetFund;

    @Column(name = "collected_fund")
    private Double collectedFund;

    @Column(name = "project_type", nullable=false)
    private ProjectType projectType;

    @Column(name = "user_id", nullable=false, updatable = false)
    private Long userId;

}
