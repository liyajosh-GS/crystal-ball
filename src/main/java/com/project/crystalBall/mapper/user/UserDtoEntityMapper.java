package com.project.crystalball.mapper.user;

import com.project.crystalball.dto.User.User;
import com.project.crystalball.entity.user.UserEntity;
import com.project.crystalball.mapper.AbstractDtoEntityMapper;
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
