package me.gold.reporesistory;

import me.gold.model.Expensives;
import me.gold.model.credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensivesRespository extends JpaRepository<Expensives, Integer> {


}
