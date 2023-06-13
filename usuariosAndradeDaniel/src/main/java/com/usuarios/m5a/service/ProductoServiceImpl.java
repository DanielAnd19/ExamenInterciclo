/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usuarios.m5a.service;

import com.usuarios.m5a.model.Productos;
import com.usuarios.m5a.repository.ProductoRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Danie
 */
@Service
public class ProductoServiceImpl extends GenericServiceImpl<Productos, Integer> implements GenericService<Productos, Integer> {

    @Autowired
    ProductoRepository pRepository;

    @Override
    public CrudRepository<Productos, Integer> getDao() {

        return pRepository;

    }

}
