package com.project.crystalBall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.OffsetDateTime;
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public abstract class AbstractEntity extends AbstractFinalEntity {

    @UpdateTimestamp
    @Column(name = "record_update_time", nullable = false)
    private OffsetDateTime recordUpdateTime;

}
