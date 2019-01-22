package com.example.radiosfax.dao;


import com.example.radiosfax.entities.Emission;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface EmissionRepository extends JpaRepository<Emission, String>
{
    
}