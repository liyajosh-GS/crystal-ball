package com.project.crystalBall.mapper.user;

import com.project.crystalBall.dto.User.User;
import com.project.crystalBall.entity.user.UserEntity;
import com.project.crystalBall.mapper.AbstractDtoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoEntityMapper extends AbstractDtoEntityMapper<User, UserEntity> {

    @Override
    protected Class<User> getDtoClass() {
        return User.class;
    }

    @Override
    protected Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }
}
