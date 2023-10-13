package com.project.crystalBall.service.impl.bankDetails;

import com.project.crystalBall.dto.bankDetails.BankDetails;
import com.project.crystalBall.entity.bankDetails.BankDetailsEntity;
import com.project.crystalBall.mapper.DtoEntityMapper;
import com.project.crystalBall.mapper.bankDetails.BankDetailsDtoEntityMapper;
import com.project.crystalBall.repository.BankDetailsRepository;
import com.project.crystalBall.repository.BankRepositoryFactory;
import com.project.crystalBall.service.impl.AbstractDataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BankService extends AbstractDataTransactionService<BankDetails, Long, BankDetailsEntity> {

    @Autowired
    BankDetailsRepository repository;

    @Autowired
    BankDetailsDtoEntityMapper mapper;

    @Autowired
    BankRepositoryFactory bankRepositoryFactory;

    protected BankService(BankRepositoryFactory bankRepositoryFactory, BankDetailsDtoEntityMapper mapper) {
        super(bankRepositoryFactory, mapper);
    }
}
