package com.project.crystalBall.entity.project;

import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.entity.Contribution;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Data
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
    @Column(name = "creators", nullable=false, updatable = false)
    private List<String> creators;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "contributions")
    private List<Contribution> contributions;

    @Enumerated(EnumType.STRING)
    @Column(name = "funding_status")
    private FundingStatus fundingStatus;

    @Column(name = "target_fund", nullable=false)
    private double targetFund;

    @Column(name = "project_type", nullable=false)
    private ProjectType projectType;

}
