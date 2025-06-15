package de.cloudypanda.money.model.repository;

import de.cloudypanda.money.model.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
}
