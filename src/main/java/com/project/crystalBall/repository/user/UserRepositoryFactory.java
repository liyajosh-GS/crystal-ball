package com.project.crystalBall.repository.user;

import com.project.crystalBall.entity.user.UserEntity;
import com.project.crystalBall.repository.RepositoryFactory;
import com.project.crystalBall.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryFactory implements RepositoryFactory<UserEntity, Long> {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRepository getRepository()  {
        return  userRepository;
    }
}
