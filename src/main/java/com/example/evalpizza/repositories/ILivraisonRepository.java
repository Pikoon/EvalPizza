package com.example.evalpizza.repositories;

import com.example.evalpizza.entities.LivraisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILivraisonRepository extends JpaRepository<LivraisonEntity, Integer> {
}
