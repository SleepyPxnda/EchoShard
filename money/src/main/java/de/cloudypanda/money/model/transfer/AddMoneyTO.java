package de.cloudypanda.money.model.transfer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddMoneyTO {
    private UUID playerId;
    private Double amount;
}
