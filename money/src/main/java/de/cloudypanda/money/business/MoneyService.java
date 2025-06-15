package de.cloudypanda.money.business;

import de.cloudypanda.money.model.entity.MoneyEntity;
import de.cloudypanda.money.model.repository.MoneyRepository;
import de.cloudypanda.money.model.transfer.CreateTransactionTO;
import de.cloudypanda.money.model.transfer.MoneyTO;
import de.cloudypanda.money.model.transfer.UpdateMoneyTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MoneyService {
    private final MoneyRepository moneyRepository;
    private final TransactionService transactionService;

    public MoneyTO updateMoney(UpdateMoneyTO updateMoneyTO) {
        return switch (updateMoneyTO.getUpdateType()) {
            case ADD -> addMoney(updateMoneyTO);
            case SUBTRACT -> subtractMoney(updateMoneyTO);
            case REPLACE -> replaceMoney(updateMoneyTO);
        };
    }

    private MoneyTO replaceMoney(UpdateMoneyTO updateMoneyTO) {
        var optionalPlayer = moneyRepository.findByPlayerId(updateMoneyTO.getPlayerId());

        if (optionalPlayer.isPresent()) {
            var player = optionalPlayer.get();
            player.setAmount(updateMoneyTO.getAmount());
            var updatedPlayer = moneyRepository.save(player);
            return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
        }

        MoneyEntity moneyEntity = new MoneyEntity(true);
        moneyEntity.setPlayerId(updateMoneyTO.getPlayerId());
        moneyEntity.setAmount(updateMoneyTO.getAmount());
        var updatedPlayer = moneyRepository.save(moneyEntity);

        CreateTransactionTO createTransactionTO = new CreateTransactionTO(UUID.fromString("0000-0000-0000-0000"), updateMoneyTO.getPlayerId(), updateMoneyTO.getAmount());
        transactionService.createTransaction(createTransactionTO);

        return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
    }

    private MoneyTO addMoney(UpdateMoneyTO updateMoneyTO) {
        var optionalPlayer = moneyRepository.findByPlayerId(updateMoneyTO.getPlayerId());

        if (optionalPlayer.isPresent()) {
            var player = optionalPlayer.get();
            player.setAmount(player.getAmount() + updateMoneyTO.getAmount());
            var updatedPlayer = moneyRepository.save(player);
            return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
        }

        MoneyEntity moneyEntity = new MoneyEntity(true);
        moneyEntity.setPlayerId(updateMoneyTO.getPlayerId());
        moneyEntity.setAmount(updateMoneyTO.getAmount());
        var updatedPlayer = moneyRepository.save(moneyEntity);

        CreateTransactionTO createTransactionTO = new CreateTransactionTO(UUID.fromString("0000-0000-0000-0000"), updateMoneyTO.getPlayerId(), updateMoneyTO.getAmount());
        transactionService.createTransaction(createTransactionTO);

        return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
    }

    private MoneyTO subtractMoney(UpdateMoneyTO updateMoneyTO) {
        var optionalPlayer = moneyRepository.findByPlayerId(updateMoneyTO.getPlayerId());
        if (optionalPlayer.isPresent()) {
            var player = optionalPlayer.get();
            player.setAmount(player.getAmount() - updateMoneyTO.getAmount());
            var updatedPlayer = moneyRepository.save(player);
            return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
        }

        MoneyEntity moneyEntity = new MoneyEntity(false);
        moneyEntity.setPlayerId(updateMoneyTO.getPlayerId());
        moneyEntity.setAmount(0);
        var updatedPlayer = moneyRepository.save(moneyEntity);
        return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
    }
}
