package com.project.crystalBall.repository;

import com.project.crystalBall.entity.bankDetails.BankDetailsEntity;
import com.project.crystalBall.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class BankRepositoryFactory implements RepositoryFactory<BankDetailsEntity, Long>{

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Override
    public BankDetailsRepository getRepository() {
//        if(entityClass.equals(BankDetailsEntity.class)){
//            return (JpaRepository<T, Long>) bankDetailsRepository;
//        }
//        throw new IllegalAccessException("Unsupported entity");
        return bankDetailsRepository;
    }
}
