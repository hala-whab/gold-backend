package me.gold.dao;

import me.gold.model.Usr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserDao extends CrudRepository<Usr, Long> {
    Usr findByUsername(String username);


}
