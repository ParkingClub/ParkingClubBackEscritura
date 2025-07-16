package com.kubocode.ParkingClubEscritura.dto;

import java.math.BigDecimal;

public class UbicacionSucursalDTO {
    private Long id;
    private BigDecimal latitud;
    private BigDecimal longitud;

    public UbicacionSucursalDTO() {
    }

    public UbicacionSucursalDTO(Long id, BigDecimal latitud, BigDecimal longitud) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
}
