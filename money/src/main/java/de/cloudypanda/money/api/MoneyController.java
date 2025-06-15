package de.cloudypanda.money.api;

import de.cloudypanda.money.business.MoneyService;
import de.cloudypanda.money.model.transfer.MoneyTO;
import de.cloudypanda.money.model.transfer.UpdateMoneyTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MoneyController implements MoneyApi {
    private final MoneyService moneyService;

    @Override
    public ResponseEntity<MoneyTO> updateMoney(UpdateMoneyTO moneyTO) {
        var result = moneyService.updateMoney(moneyTO);
        return ResponseEntity.ok(result);
    }
}
