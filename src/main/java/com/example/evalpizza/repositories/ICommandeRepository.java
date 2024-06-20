package com.example.evalpizza.repositories;

import com.example.evalpizza.entities.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommandeRepository extends JpaRepository<CommandeEntity, Integer> {
}
