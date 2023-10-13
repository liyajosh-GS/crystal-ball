package com.project.crystalBall.entity.bankDetails;

import com.project.crystalBall.config.encryptorConfig.AesEncryptor;
import com.project.crystalBall.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = BankDetailsEntity.TABLE_NAME)
public class BankDetailsEntity extends AbstractEntity {

    public static final String TABLE_NAME = "bank_details";

    @Column(name = "account_number", columnDefinition = "text", length=32, nullable=false)
    @Convert(converter = AesEncryptor.class)
    private String accountNumber;

    @Column(name = "account_holder", columnDefinition = "text", length=50, nullable=false)
    @Convert(converter = AesEncryptor.class)
    private String accountHolder;

    @Column(name = "code", length=12, nullable=false)
    private String code;

    @Column(name = "project_id", length=10, nullable=false)
    private String projectId;
}
