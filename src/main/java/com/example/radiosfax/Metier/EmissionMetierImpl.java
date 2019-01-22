package com.example.radiosfax.Metier;

import com.example.radiosfax.dao.EmissionRepository;
import com.example.radiosfax.entities.Emission;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmissionMetierImpl implements EmissionMetier{

    @Autowired
    public EmissionRepository emissionRepository;

    @Override
    public List<Emission> getListEmission() {
        return emissionRepository.findAll(); 
    }

    
    
    
    
}
