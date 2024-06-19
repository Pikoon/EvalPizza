package com.example.evalpizza.controllers;

import com.example.evalpizza.dtos.InUtilisateurDto;
import com.example.evalpizza.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurRessource {

    @Autowired
    private UtilisateurService service;

    @GetMapping("/get/{id}")
    public ResponseEntity get (@PathVariable String id) {
        Integer idInt = null;
        try {
            idInt = Integer.parseInt(id);
        }catch (Exception e) {
            return new ResponseEntity("l'id n'est pas bon", HttpStatusCode.valueOf(500));
        }
        return new ResponseEntity(service.get(idInt), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getListe")
    public ResponseEntity getListe (){
        System.out.println("getliste");
        return new ResponseEntity(service.getListeUtilisateurs(), HttpStatusCode.valueOf(200));
    }

    @PostMapping ("/create")
    public ResponseEntity creer (@RequestBody InUtilisateurDto in){
        service.ajoutUtilisateur(in);
        return new ResponseEntity("Utilisateur ajouté", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        Integer idInt = null;
        try {
            idInt = Integer.parseInt(id);
        }catch (Exception e) {
            return new ResponseEntity("l'id n'est pas bon", HttpStatusCode.valueOf(500));
        }

        service.delete(idInt);
        return new ResponseEntity("C'est supprimé", HttpStatusCode.valueOf(200));
    }
}
