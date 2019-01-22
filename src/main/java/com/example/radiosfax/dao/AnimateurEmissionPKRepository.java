package com.example.radiosfax.dao;

import com.example.radiosfax.entities.AnimateurEmission;
import com.example.radiosfax.entities.AnimateurEmissionPK;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface AnimateurEmissionPKRepository extends JpaRepository<AnimateurEmission, AnimateurEmissionPK>
{
    
}