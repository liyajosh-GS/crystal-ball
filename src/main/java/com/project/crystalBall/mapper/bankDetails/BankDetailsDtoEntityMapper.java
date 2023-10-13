package com.project.crystalBall.mapper.bankDetails;

import com.project.crystalBall.dto.bankDetails.BankDetails;
import com.project.crystalBall.entity.bankDetails.BankDetailsEntity;
import com.project.crystalBall.mapper.AbstractDtoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class BankDetailsDtoEntityMapper extends AbstractDtoEntityMapper<BankDetails, BankDetailsEntity> {
    @Override
    protected Class<BankDetails> getDtoClass() {
        return BankDetails.class;
    }

    @Override
    protected Class<BankDetailsEntity> getEntityClass() {
        return BankDetailsEntity.class;
    }
}
