package com.project.crystalBall.dto.User;

import com.project.crystalBall.dto.AbstractDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractDto {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @Email
    private String email;
}
