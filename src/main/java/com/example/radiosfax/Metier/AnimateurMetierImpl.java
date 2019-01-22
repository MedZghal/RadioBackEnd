 
package com.example.radiosfax.Metier;

import com.example.radiosfax.dao.AnimateurRepository;
import com.example.radiosfax.entities.Animateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class AnimateurMetierImpl implements AnimateurMetier{
    
    @Autowired
    public AnimateurRepository animateurRepository;

    @Override
    public List<Animateur> listAnimateurs() {
         return animateurRepository.findAll();
    }


    
}
