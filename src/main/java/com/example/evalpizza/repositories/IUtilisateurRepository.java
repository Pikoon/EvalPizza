package com.example.evalpizza.repositories;

import com.example.evalpizza.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {
}
