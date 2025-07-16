package com.kubocode.ParkingClubEscritura.dto;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public class ModalSucursalMovilDTO {
    private String nombre;
    private BigDecimal preciotarifa;
    private Integer plazasdisponibles;
    private String ubicacion;
    private String descripcion;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private List<String> fotografias;

    //Esta entidad se usa para entregar los datos al modal movil para todos los usuarios
    public ModalSucursalMovilDTO() {
    }

    public ModalSucursalMovilDTO(String descripcion, List<String> fotografias, LocalTime horaApertura, LocalTime horaCierre, String nombre, Integer plazasdisponibles, BigDecimal preciotarifa, String ubicacion) {
        this.descripcion = descripcion;
        this.fotografias = fotografias;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.nombre = nombre;
        this.plazasdisponibles = plazasdisponibles;
        this.preciotarifa = preciotarifa;
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPlazasdisponibles() {
        return plazasdisponibles;
    }

    public void setPlazasdisponibles(Integer plazasdisponibles) {
        this.plazasdisponibles = plazasdisponibles;
    }

    public BigDecimal getPreciotarifa() {
        return preciotarifa;
    }

    public void setPreciotarifa(BigDecimal preciotarifa) {
        this.preciotarifa = preciotarifa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getFotografias() {
        return fotografias;
    }

    public void setFotografias(List<String> fotografias) {
        this.fotografias = fotografias;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }
}
