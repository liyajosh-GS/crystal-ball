package com.project.crystalBall.repository;

import com.project.crystalBall.entity.AbstractEntity;
import com.project.crystalBall.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryFactory implements RepositoryFactory<UserEntity, Long>{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRepository getRepository()  {
//        if(entityClass.equals(UserEntity.class)){
//            return (JpaRepository<T, Long>) userRepository;
//        }
//        throw new IllegalAccessException("Unsupported entity");
        return  userRepository;
    }
}
