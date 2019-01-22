package com.example.radiosfax.dao;

import com.example.radiosfax.entities.Animateur;
import com.example.radiosfax.entities.AnimateurEmission;
import com.example.radiosfax.entities.AnimateurEmissionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimateurEmissionRepository extends JpaRepository<AnimateurEmission,AnimateurEmissionPK>{
    
}