package de.cloudypanda.money.model.repository;

import de.cloudypanda.money.model.entity.MoneyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface MoneyRepository extends CrudRepository<MoneyEntity, Long> {
    Optional<MoneyEntity> findByPlayerId(UUID playerId);
}
