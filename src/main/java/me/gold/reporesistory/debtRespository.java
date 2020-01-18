package me.gold.reporesistory;


import me.gold.model.debt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface debtRespository extends JpaRepository<debt, Integer> {

    @Query("UPDATE debt SET remaning = :remaning , duedate= :duedate where id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void modifyremaning(@Param("remaning") String remaning,@Param("duedate") String duedate, @Param("id") int id);

    @Query(value = "SELECT * FROM debt WHERE customer_id = ?1", nativeQuery = true)
    List<debt> finddebtbycustomerid(String id);

    @Query("delete from debt where id=:id ")
    @Modifying(clearAutomatically = true)
    @Transactional
    void deletwhereremaningequalzero(@Param("id") int id);

}
