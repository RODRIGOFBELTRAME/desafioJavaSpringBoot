package com.desafioPicpay.desafioPicpay.repostories;

import com.desafioPicpay.desafioPicpay.domain.Transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
