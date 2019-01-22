/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radiosfax.dao;

import com.example.radiosfax.entities.Intervention;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Integer>
{
    @Query(value="select MAX(i.num_intervention)  FROM intervention i", nativeQuery = true)
    public Integer GETnuminterv();
    
}