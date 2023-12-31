package com.project.crystalBall.repository.bankDetails;

import com.project.crystalBall.entity.bankDetails.BankDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetailsEntity, Long> {
}
