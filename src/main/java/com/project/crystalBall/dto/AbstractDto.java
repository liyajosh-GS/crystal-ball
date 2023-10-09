package com.project.crystalball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDto {

    Long id;

    //for return responses
    OffsetDateTime createdTime;

    OffsetDateTime updateTime;
}
