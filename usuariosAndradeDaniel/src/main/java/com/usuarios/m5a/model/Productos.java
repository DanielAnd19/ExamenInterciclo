/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usuarios.m5a.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Danie
 */
@Entity
@Data
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Size(max = 100, message = "El atributo debe tener máximo 100 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "El precio no puede estar vacio")
    @Min(value = 0, message = "El precio debe ser mayor a 0")
    @Column(name = "precio")
    private double precio;

    @NotNull(message = "La cantidad no puede estar vacio")
    @Digits(integer = 10, fraction = 0, message = "El valor debe ser un entero")
    @Column(name = "cant")
    private int cant;

    @NotNull(message = "La cantidad no puede estar vacio")
    @Column(name = "subtotal")
    private Double subtotal;

    @NotNull(message = "La cantidad no puede estar vacio")
    @Column(name = "descuento")
    private Double descuento;

    @NotNull(message = "La cantidad no puede estar vacio")
    @Column(name = "iva")
    private Double iva;

    @NotNull(message = "La cantidad no puede estar vacio")
    @Column(name = "pvp")
    private Double pvp;
    
    public double calcularTotal() {
        return precio * cant;
    }

}
