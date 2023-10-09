package com.project.crystalball.dto.User;

import com.project.crystalball.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractDto {

    private String userName;
    private String password;
}
