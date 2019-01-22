package com.example.radiosfax.services;


import com.example.radiosfax.Metier.InterventionMetier;
import com.example.radiosfax.entities.Intervention;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InterventionService{
    
    @Autowired
    public InterventionMetier interventionMetier;
    
    @GetMapping("/ListIntervention")
    public List<Intervention> getListIntervention() {
        return interventionMetier.getListInvervention();
    }
    
    @PostMapping("/AjouterInterv")
     public Intervention AjouterInterv(@RequestParam("numIntervention") String numIntervention,@RequestParam("nom")  String nom,@RequestParam("prenom")  String prenom,@RequestParam("description")  String description,@RequestParam("tel")  String tel,@RequestParam("localisationActuel")  String localisationActuel,@RequestParam("localisationImage")  String localisationImage,@RequestParam("type")  String type,@RequestParam("etat")  String etat) {
         return interventionMetier.AjouterInterv(numIntervention, nom, prenom, description, tel, localisationActuel, localisationImage, type, etat);
    }
     
    @PostMapping("/DeleteIntervention")
    public String DeleteIntervention(@RequestParam("numIntervention") int numIntervention) {
        interventionMetier.DeleteIntervention(numIntervention);
        return "true";
    }
}
