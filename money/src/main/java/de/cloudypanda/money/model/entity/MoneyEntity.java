package de.cloudypanda.money.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table(value = "money",schema = "money")
@Getter
@Setter
@RequiredArgsConstructor
public class MoneyEntity implements Serializable, Persistable<Long> {
    @Id
    private Long id;

    @Column("player_id")
    private UUID playerId;

    @Column("amount")
    private double amount;

    @Transient
    private final boolean isNew;

    @Override
    public boolean isNew() {
        return isNew;
    }

    public MoneyEntity() {
        this.isNew = false;
    }
}
