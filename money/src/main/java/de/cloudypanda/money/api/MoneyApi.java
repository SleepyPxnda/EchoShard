package de.cloudypanda.money.api;

import de.cloudypanda.money.model.transfer.AddMoneyTO;
import de.cloudypanda.money.model.transfer.MoneyTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MoneyApi {

    @PostMapping("/money/add")
    ResponseEntity<MoneyTO> addMoney(@RequestBody AddMoneyTO addMoneyTO);
}
