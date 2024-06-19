package com.example.evalpizza.services;

import com.example.evalpizza.dtos.InUtilisateurDto;
import com.example.evalpizza.dtos.OutUtilisateurDto;
import com.example.evalpizza.entities.UtilisateurEntity;
import com.example.evalpizza.repositories.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private IUtilisateurRepository repository;

    public OutUtilisateurDto toDto (UtilisateurEntity entity){
        OutUtilisateurDto dto = new OutUtilisateurDto();

        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setDateNaissance(entity.getDateNaissance());
        dto.setDateInscription(entity.getDateInscription());
        dto.setType(entity.getType().toString());

        return dto;
    }

    public OutUtilisateurDto get(Integer id){return toDto(repository.findById(id).get());}

    public void ajoutUtilisateur (InUtilisateurDto utilisateur){
        System.out.println("début");
        UtilisateurEntity entity = new UtilisateurEntity();
        entity.setNom(utilisateur.getNom());
        entity.setPrenom(utilisateur.getPrenom());
        entity.setDateNaissance(utilisateur.getDate_naissance());
        entity.setDateInscription(utilisateur.getDate_inscription());
        entity.setType(utilisateur.getType());

        repository.saveAndFlush(entity);
        System.out.println("atteint");
    }

    public List<OutUtilisateurDto> getListeUtilisateurs(){

        ArrayList<OutUtilisateurDto> listUtilisateurs = new ArrayList<>();
        List<UtilisateurEntity> listEntity = repository.findAll();
        if (listEntity != null){

            listEntity.forEach(entity -> {
                listUtilisateurs.add(toDto(entity));
            });
            return listUtilisateurs;
        }
        //Meriterait une meilleur gestion des erreurs. Pas le temps
        return null;
    }

    public void delete (Integer id){
        repository.deleteById(id);
    }

}
