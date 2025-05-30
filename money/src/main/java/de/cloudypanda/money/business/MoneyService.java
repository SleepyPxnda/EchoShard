package de.cloudypanda.money.business;

import de.cloudypanda.money.model.entity.MoneyEntity;
import de.cloudypanda.money.model.repository.MoneyRepository;
import de.cloudypanda.money.model.transfer.AddMoneyTO;
import de.cloudypanda.money.model.transfer.MoneyTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoneyService {
    private final MoneyRepository moneyRepository;

    public MoneyTO addMoney(AddMoneyTO addMoneyTO) {
        var optionalPlayer = moneyRepository.findByPlayerId(addMoneyTO.getPlayerId());

        if (optionalPlayer.isPresent()) {
            var player = optionalPlayer.get();
            player.setAmount(player.getAmount() + addMoneyTO.getAmount());
            var updatedPlayer = moneyRepository.save(player);
            return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
        }

        MoneyEntity moneyEntity = new MoneyEntity(true);
        moneyEntity.setPlayerId(addMoneyTO.getPlayerId());
        moneyEntity.setAmount(addMoneyTO.getAmount());
        var updatedPlayer = moneyRepository.save(moneyEntity);
        return new MoneyTO(updatedPlayer.getPlayerId(), updatedPlayer.getAmount());
    }
}
