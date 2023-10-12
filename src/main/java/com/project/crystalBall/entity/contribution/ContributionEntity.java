package com.project.crystalBall.entity.contribution;

import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.entity.AbstractFinalEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ContributionEntity.TABLE_NAME)
public final class ContributionEntity extends AbstractFinalEntity {
    public static final String TABLE_NAME = "contribution";

    @Column(name = "amount", nullable=false, updatable = false)
    private double amount;

    @Column(name = "project_id", nullable=false, updatable = false)
    private Long projectId;

    @Column(name = "user_id", nullable=false, updatable = false)
    private Long userId;
}
