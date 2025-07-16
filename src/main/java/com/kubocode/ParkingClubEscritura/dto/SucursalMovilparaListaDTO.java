package com.kubocode.ParkingClubEscritura.dto;

import com.kubocode.ParkingClubEscritura.entity.SucursalFotografia;

import java.math.BigDecimal;
import java.util.List;

public class SucursalMovilparaListaDTO {
    private Long id;
    private String nombre;
    private String ubicacion;
    private BigDecimal preciotarifa;
    private List<SucursalFotografia> fotografias;

    public SucursalMovilparaListaDTO() {
    }

    public SucursalMovilparaListaDTO(Long id, String nombre, String ubicacion, BigDecimal preciotarifa, List<SucursalFotografia> fotografias) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.preciotarifa = preciotarifa;
        this.fotografias = fotografias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public BigDecimal getPreciotarifa() {
        return preciotarifa;
    }

    public void setPreciotarifa(BigDecimal preciotarifa) {
        this.preciotarifa = preciotarifa;
    }

    public List<SucursalFotografia> getFotografias() {
        return fotografias;
    }

    public void setFotografias(List<SucursalFotografia> fotografias) {
        this.fotografias = fotografias;
    }
}
