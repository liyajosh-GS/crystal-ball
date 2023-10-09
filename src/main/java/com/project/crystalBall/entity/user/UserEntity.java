package com.project.crystalball.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.crystalball.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
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

}