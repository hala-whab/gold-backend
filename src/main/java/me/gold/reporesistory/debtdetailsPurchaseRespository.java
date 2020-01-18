package me.gold.reporesistory;



import me.gold.model.debtpurchasedetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface debtdetailsPurchaseRespository extends JpaRepository<debtpurchasedetails, Integer> {


    @Query(value = "SELECT * FROM debtpurchasedetails WHERE dept_id = ?1", nativeQuery = true)
     List<debtpurchasedetails> finddebtbpydebtid(String id);

    @Query("delete from debtpurchasedetails where dept_id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void deletwhereremaningequalzero(@Param("id") int id);
}
