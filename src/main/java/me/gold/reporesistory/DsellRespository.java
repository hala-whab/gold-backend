package me.gold.reporesistory;


import me.gold.model.Dsell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DsellRespository extends JpaRepository<Dsell, Integer> {


}
