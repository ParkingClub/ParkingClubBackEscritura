package com.kubocode.ParkingClubEscritura.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketRecaudacionDTO {
    private Long id;
    private String placa;
    private LocalDateTime hentrada;
    private LocalDateTime hsalida;
    private BigDecimal monto;
    private String tipo_pago;
    private String empleado_cierre;

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

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getEmpleado_cierre() {
        return empleado_cierre;
    }

    public void setEmpleado_cierre(String empleado_cierre) {
        this.empleado_cierre = empleado_cierre;
    }

    public TicketRecaudacionDTO() {
    }

    public TicketRecaudacionDTO(Long id, String placa, LocalDateTime hentrada, LocalDateTime hsalida, BigDecimal monto, String tipo_pago, String empleado_cierre) {
        this.id = id;
        this.placa = placa;
        this.hentrada = hentrada;
        this.hsalida = hsalida;
        this.monto = monto;
        this.tipo_pago = tipo_pago;
        this.empleado_cierre = empleado_cierre;
    }
}
