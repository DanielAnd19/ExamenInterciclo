/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usuarios.m5a.controller;

import com.usuarios.m5a.model.Productos;
import com.usuarios.m5a.service.ProductoServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Danie
 */
@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    ProductoServiceImpl prodser;

    @GetMapping("/get")
    public ResponseEntity<List<Productos>> listarProd() {
        return new ResponseEntity<>(prodser.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Productos> crearProd(@RequestBody Productos u) {

        double subtotal = u.calcularTotal();
        u.setSubtotal(subtotal);

        if (u.getSubtotal() > 50) {

            double desc = 0;
            double subtotal2 = u.getSubtotal();
            double iva = 0;
            double subtotal3 = 0;
            double pvp = 0;
            desc = u.getSubtotal() * 0.1;
            u.setDescuento(desc);
            subtotal3 = subtotal2 - desc;
            iva = subtotal3 * 0.12;
            u.setIva(iva);
            pvp = subtotal3 + iva;
            u.setPvp(pvp);

        } else {
            double desc = 0;
            double subtotal2 = u.getSubtotal();
            double total = 0;
            double iva = 0;
            double subtotal3 = 0;
            double pvp = 0;
            desc = u.getSubtotal() - 0;
            u.setDescuento(desc);
            subtotal3 = subtotal2 - desc;
            iva = subtotal3 * 0.12;
            u.setIva(iva);
            pvp = subtotal3 + iva;
            u.setPvp(pvp);

        }

        return new ResponseEntity<>(prodser.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Productos> actualizaProducto(@PathVariable Integer id, @RequestBody Productos u) {
        Productos p = prodser.findById(id);
        if (p != null) {
            try {
                p.setDescripcion(u.getDescripcion());
                p.setPrecio(u.getPrecio());
                p.setCant(u.getCant());
                p.setSubtotal(u.getSubtotal());
                p.setIva(u.getIva());
                p.setPvp(u.getPvp());

                return new ResponseEntity<>(prodser.save(p), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
