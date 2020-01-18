package me.gold.service;

import me.gold.model.Usr;
import me.gold.model.UserDto;

import java.util.List;

public interface UserService {

    Usr save(UserDto user);
    List<Usr> findAll();
    void delete(long id);
    Usr findOne(String username);

    Usr findById(Long id);
}
