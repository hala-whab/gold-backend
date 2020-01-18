package me.gold.reporesistory;


import me.gold.model.credit;
import me.gold.model.debt;
import me.gold.model.debtdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CreditRespository extends JpaRepository<credit, Integer> {
    @Query("UPDATE credit SET benefit_amount = :benefit_amount where id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void modifycredit(@Param("benefit_amount") String benefit_amount, @Param("id") int id);

    @Query(value = "SELECT * FROM credit WHERE beneficial_id = ?1", nativeQuery = true)
    List<credit> findcreditbycustomerid(String id);

    @Query("delete from credit where id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void deletwherecreditequalzero(@Param("id") int id);

}
