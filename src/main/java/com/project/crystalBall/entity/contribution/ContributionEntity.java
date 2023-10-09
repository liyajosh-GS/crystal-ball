package com.project.crystalBall.entity.contribution;

import com.project.crystalBall.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ContributionEntity.TABLE_NAME)
public class ContributionEntity extends AbstractEntity {
    public static final String TABLE_NAME = "contribution";

    @Column(name = "amount", nullable=false)
    private double amount;

    @Column(name = "project_id", nullable=false)
    private Long projectId;

    @Column(name = "user_id", nullable=false, updatable = false)
    private Long userId;
}
