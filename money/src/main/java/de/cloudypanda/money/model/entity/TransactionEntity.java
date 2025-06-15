package de.cloudypanda.money.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table(value = "transaction", schema = "money")
@Getter
@Setter
@RequiredArgsConstructor
public class TransactionEntity implements Serializable, Persistable<Long> {
    @Id
    @Column("id")
    private Long id;

    @Column("source_id")
    private UUID sourceId;

    @Column("target_id")
    private UUID targetId;

    @Column("amount")
    private double amount;

    @Transient
    private final boolean isNew;

    @Override
    public boolean isNew() {
        return isNew;
    }

    public TransactionEntity() {
        this.isNew = false;
    }
}
