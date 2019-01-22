/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radiosfax.services;


import com.example.radiosfax.Metier.AnimateurMetier;
import com.example.radiosfax.entities.Animateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class AnimateurService {
    
    @Autowired
    public AnimateurMetier animateurMetier;
    
    @GetMapping("/ListAnimateurs")
     public List<Animateur> listAnimateurs() {
        return animateurMetier.listAnimateurs();
    }
    
}
