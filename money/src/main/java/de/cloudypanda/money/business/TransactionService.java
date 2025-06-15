package de.cloudypanda.money.business;

import de.cloudypanda.money.model.entity.TransactionEntity;
import de.cloudypanda.money.model.repository.TransactionRepository;
import de.cloudypanda.money.model.transfer.CreateTransactionTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public void createTransaction(CreateTransactionTO createTransactionTO) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setSourceId(createTransactionTO.sourceID());
        transactionEntity.setTargetId(createTransactionTO.targetID());
        transactionEntity.setAmount(createTransactionTO.amount());
        transactionRepository.save(transactionEntity);
    }
}
