package com.project.crystalBall.repository.bankDetails;

import com.project.crystalBall.entity.bankDetails.BankDetailsEntity;
import com.project.crystalBall.repository.RepositoryFactory;
import com.project.crystalBall.repository.bankDetails.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankRepositoryFactory implements RepositoryFactory<BankDetailsEntity, Long> {

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Override
    public BankDetailsRepository getRepository() {
        return bankDetailsRepository;
    }
}
