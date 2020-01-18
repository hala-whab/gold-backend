package me.gold.reporesistory;


import me.gold.model.Dsell;
import me.gold.model.save;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveRespository extends JpaRepository<save, Integer> {

    @Query(value = "select * from save order by id DESC limit 1", nativeQuery = true)
    save getlastrow();
}
