package de.cloudypanda.money.model.transfer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class MoneyTO {
    public final UUID playerId;
    public final double amount;
}
