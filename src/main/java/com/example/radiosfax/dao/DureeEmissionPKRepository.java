package com.example.radiosfax.dao;

import com.example.radiosfax.entities.DureeEmission;
import com.example.radiosfax.entities.DureeEmissionPK;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface DureeEmissionPKRepository extends JpaRepository<DureeEmission, DureeEmissionPK>
{
    
}