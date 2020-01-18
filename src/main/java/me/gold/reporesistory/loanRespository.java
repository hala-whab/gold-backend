package me.gold.reporesistory;

import me.gold.model.credit;
import me.gold.model.loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface loanRespository extends JpaRepository<loan, Integer> {
    @Query(value = "SELECT * FROM credit WHERE beneficial_id = ?1", nativeQuery = true)
    List<credit> findcritbycustomerid(String id);
    @Query("UPDATE debt SET remaning = :remaning where id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void modifyremaning(@Param("remaning") String remaning, @Param("id") int id);


    @Query("delete from debt where id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void deletwhereremaningequalzero(@Param("id") int id);

}
