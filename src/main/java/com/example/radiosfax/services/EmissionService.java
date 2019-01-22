package com.example.radiosfax.services;

import com.example.radiosfax.Metier.EmissionMetier;
import com.example.radiosfax.entities.Emission;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmissionService{
    
    @Autowired
    public EmissionMetier animateurMetier;
    
    @GetMapping("/ListEmission")
    public List<Emission> getListEmission() {
        return animateurMetier.getListEmission();
    }
    
}
