package com.project.crystalBall.service.impl.bankDetails;

import com.project.crystalBall.dto.bankDetails.BankDetails;
import com.project.crystalBall.entity.bankDetails.BankDetailsEntity;
import com.project.crystalBall.mapper.bankDetails.BankDetailsDtoEntityMapper;
import com.project.crystalBall.repository.bankDetails.BankDetailsRepository;
import com.project.crystalBall.service.impl.AbstractDataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BankService extends AbstractDataTransactionService<BankDetails, Long, BankDetailsEntity> {

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Autowired
    BankDetailsDtoEntityMapper mapper;

    protected BankService(BankDetailsDtoEntityMapper mapper) {
        super(mapper);
    }

    @Override
    public JpaRepository<BankDetailsEntity, Long> getRepository() {
        return bankDetailsRepository;
    }
}
