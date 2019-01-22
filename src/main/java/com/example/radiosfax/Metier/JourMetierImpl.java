package com.example.radiosfax.Metier;


import com.example.radiosfax.dao.JourRepository;
import com.example.radiosfax.entities.Jour;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourMetierImpl implements JourMetier{

    @Autowired
    public JourRepository jourRepository;

    @Override
    public List<Jour> getListJour() {
       return jourRepository.findAll(); 
    }

    

}
