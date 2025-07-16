package com.kubocode.ParkingClubEscritura.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tarifas")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación muchas tarifas -> una sucursal
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    // Ajustar el tipo si se manejan decimales o un valor entero
    @Column(nullable = false)
    private Integer tiempo;

    // Ajustar la precisión/escala según corresponda
    @Column(name = "monto_tarifa", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTarifa;

    // =========================
    //       Constructor
    // =========================
    public Tarifa() {
    }

    // =========================
    //   Getters y Setters
    // =========================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public BigDecimal getMontoTarifa() {
        return montoTarifa;
    }

    public void setMontoTarifa(BigDecimal montoTarifa) {
        this.montoTarifa = montoTarifa;
    }
}

