package com.example.radiosfax.dao;

import com.example.radiosfax.entities.*;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface JourRepository extends JpaRepository<Jour, String>
{
   
}