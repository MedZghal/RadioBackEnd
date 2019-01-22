package com.example.radiosfax.Metier;

import com.example.radiosfax.entities.Intervention;
import java.util.List;


public interface InterventionMetier {
    List<Intervention> getListInvervention();
    Intervention AjouterInterv(String numIntervention, String nom, String prenom, String description, String tel, String localisationActuel, String localisationImage, String type, String etat);
    void DeleteIntervention(int numIntervention);
}
