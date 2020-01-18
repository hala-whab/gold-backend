package me.gold.reporesistory;


import me.gold.model.HD;
import me.gold.model.credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DsellHDRespository extends JpaRepository<HD, Integer> {
    @Query("UPDATE HD SET amount = :amount where id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void modifyamount(@Param("amount") String amount, @Param("id") int id);

}
