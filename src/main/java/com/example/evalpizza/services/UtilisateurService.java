package com.example.evalpizza.services;

import com.example.evalpizza.dtos.InUtilisateurDto;
import com.example.evalpizza.entities.UtilisateurEntity;
import com.example.evalpizza.repositories.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private IUtilisateurRepository repository;



    public void addUtilisateur (InUtilisateurDto utilisateur){
        UtilisateurEntity entity = new UtilisateurEntity();
        entity.setNom(utilisateur.getNom());
        entity.setPrenom(utilisateur.getPrenom());
        entity.setDateNaissance(utilisateur.getDate_naissance());
        entity.setDateInscription(utilisateur.getDate_inscription());
        entity.setType(utilisateur.getType());

        repository.saveAndFlush(entity);
    }

}
