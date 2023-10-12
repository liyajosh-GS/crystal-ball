package com.project.crystalBall.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.crystalBall.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity extends AbstractEntity {

    public static final String TABLE_NAME = "user_details";

    @Column(name = "name", length=50, nullable=false)
    private String name;

    @Column(name = "password", length=500, nullable=false)
    private String password;

    @Column(name = "email", length=255, nullable=false)
    private String email;

}
