package me.gold.reporesistory;


import me.gold.model.Transactions;
import me.gold.model.debtdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRespository extends JpaRepository<Transactions, Integer> {

}
