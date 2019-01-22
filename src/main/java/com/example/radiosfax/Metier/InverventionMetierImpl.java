package com.example.radiosfax.Metier;


import com.example.radiosfax.dao.InterventionRepository;
import com.example.radiosfax.entities.Intervention;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InverventionMetierImpl implements InterventionMetier{

    @Autowired
    public InterventionRepository interventionRepository;

    @Override
    public List<Intervention> getListInvervention() {
        return interventionRepository.findAll(); 
    }

    @Override
    public Intervention AjouterInterv(String numIntervention, String nom, String prenom, String description, String tel, String localisationActuel, String localisationImage, String type, String etat) {
         
        Integer NUmINTV = this.interventionRepository.GETnuminterv() != null ? this.interventionRepository.GETnuminterv()+1 : 19001;
        System.out.println("com.example.radiosfax.Metier.InverventionMetierImpl.AjouterInterv()"+NUmINTV);
        Intervention dbFile = new Intervention(NUmINTV, nom, prenom, description, tel, localisationActuel, localisationImage, type, etat);
        return (Intervention)this.interventionRepository.save((Intervention)dbFile);
    }

    @Override
    public void DeleteIntervention(int numIntervention) {
        interventionRepository.deleteById(numIntervention);
    }

}
