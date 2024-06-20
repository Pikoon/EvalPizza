package com.example.evalpizza.services;

import com.example.evalpizza.dtos.OutLivreurDto;
import com.example.evalpizza.dtos.OutSyntheseClient;
import com.example.evalpizza.entities.CommandeEntity;
import com.example.evalpizza.entities.LivraisonEntity;
import com.example.evalpizza.entities.UtilisateurEntity;
import com.example.evalpizza.enumerations.TypeEnum;
import com.example.evalpizza.repositories.ICommandeRepository;
import com.example.evalpizza.repositories.ILivraisonRepository;
import com.example.evalpizza.repositories.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivraisonService {

    @Autowired
    private ILivraisonRepository repositoryLivraison;
    @Autowired
    private ICommandeRepository repositoryCommande;
    @Autowired
    private IUtilisateurRepository repositoryUtilisateur;

    public List<OutLivreurDto> getMeilleursLivreurs(){
        List<LivraisonEntity> listLivraison = repositoryLivraison.findAll();
        List<OutLivreurDto> listDto = new ArrayList<>();
        List<UtilisateurEntity> listUtilisateurs = repositoryUtilisateur.findAll();

        listUtilisateurs.forEach(it ->{
            if (it.getType()!= TypeEnum.CLIENT){
                OutLivreurDto livreur = new OutLivreurDto();
                livreur.setNom(it.getNom());
                livreur.setPrenom(it.getPrenom());
                livreur.setId(it.getId());
                listDto.add(livreur);
            }
        });

        listLivraison.forEach(livraison -> {
            listDto.forEach( livreur -> {
                if (livreur.getId() == livraison.getIdLivreur()){
                    livreur.setDistanceTotale(livreur.getDistanceTotale() + livraison.getDistanceParcourue());
                }
            });
        });

        List<OutLivreurDto> top3 = listDto.stream()
                .sorted(Comparator.comparingInt(OutLivreurDto::getDistanceTotale)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());
        return top3;
    }


    public OutSyntheseClient getSynthese (Integer id){
        List<LivraisonEntity> listLivraison = repositoryLivraison.findAll();
        ArrayList<CommandeEntity> listCommandesConcernees = new ArrayList<>();
        OutSyntheseClient dto = new OutSyntheseClient();

        listLivraison.forEach(it -> {
            //Check que la livraison concerne bien le bon client
            if (it.getIdClient() == id){
                //On ajoute la commande a la liste
                listCommandesConcernees.add(repositoryCommande.findById(it.getIdCommande()).get());
            }
        });

        if (listCommandesConcernees != null){
            UtilisateurEntity utilisateur = repositoryUtilisateur.findById(id).get();
            dto.setNom(utilisateur.getNom());
            dto.setPrenom(utilisateur.getPrenom());
            int nbreCommande = 0;
            int montantTotal = 0;
            for (CommandeEntity commande : listCommandesConcernees){
                nbreCommande++;
                montantTotal += commande.getPrixTotal();
            }
            dto.setNbCommandes(nbreCommande);
            dto.setMontant(montantTotal);
        }
        return dto;
    }
}
