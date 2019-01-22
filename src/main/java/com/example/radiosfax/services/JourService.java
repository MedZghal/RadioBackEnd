package com.example.radiosfax.services;


import com.example.radiosfax.Metier.JourMetier;
import com.example.radiosfax.entities.Jour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JourService{
    
    @Autowired
    public JourMetier animateurMetier;
    
    @GetMapping("/ListJour")
    public List<Jour> getListJour() {
        return animateurMetier.getListJour();
    }
    
}
