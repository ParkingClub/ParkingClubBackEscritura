package com.kubocode.ParkingClubEscritura.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketDetalleDTO {
    private Long id;
    private String placa;
    private LocalDateTime hentrada;
    private LocalDateTime hsalida;
    private BigDecimal monto;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHentrada() {
        return hentrada;
    }
    public void setHentrada(LocalDateTime hentrada) {
        this.hentrada = hentrada;
    }

    public LocalDateTime getHsalida() {
        return hsalida;
    }
    public void setHsalida(LocalDateTime hsalida) {
        this.hsalida = hsalida;
    }

    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
