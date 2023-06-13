/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usuarios.m5a.repository;

import com.usuarios.m5a.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Danie
 */
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

    @Query(value = "Select * from productos u where u.nombre = :nombre", nativeQuery = true)
    public Productos buscarUsuario(String nombre);

}
