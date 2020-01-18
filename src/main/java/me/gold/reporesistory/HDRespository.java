package me.gold.reporesistory;


import me.gold.model.HD;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface HDRespository extends JpaRepository<HD, Integer> {


}
