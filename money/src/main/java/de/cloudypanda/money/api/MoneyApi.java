package de.cloudypanda.money.api;

import de.cloudypanda.money.model.transfer.MoneyTO;
import de.cloudypanda.money.model.transfer.UpdateMoneyTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MoneyApi {

    @PutMapping("/money")
    ResponseEntity<MoneyTO> updateMoney(@RequestBody UpdateMoneyTO moneyTO);
}
