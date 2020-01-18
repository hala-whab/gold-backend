package me.gold.reporesistory;


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
public interface debtdetailsRespository extends JpaRepository<debtdetails, Integer> {

    @Query(value = "SELECT * FROM debtdetails WHERE dept_id = ?1", nativeQuery = true)
    List<debtdetails> finddebtbydebtid(String id);

    @Query("delete from debtdetails where dept_id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void deletwhereremaningequalzero(@Param("id") int id);
}
