package de.cloudypanda.money.model.transfer;

import java.util.UUID;

public record CreateTransactionTO(UUID sourceID, UUID targetID, double amount) {
}
