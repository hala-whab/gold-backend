package me.gold.reporesistory;


import me.gold.model.Dpurchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DpurchaseRespository extends JpaRepository<Dpurchase, Integer> {


}
