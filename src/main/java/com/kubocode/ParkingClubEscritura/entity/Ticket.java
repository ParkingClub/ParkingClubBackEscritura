package com.kubocode.ParkingClubEscritura.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    // Mapeamos hentrada con un tipo de fecha/tiempo apropiado en Java
    @Column(name = "hentrada")
    private LocalDateTime hentrada;

    @Column(name = "hsalida")
    private LocalDateTime hsalida;

    //mfinal-->monto final
    @Column(name = "mfinal")
    private BigDecimal mfinal;

    private Integer estado;

    @Column(name = "tpago")
    private String tpago;

    /**
     * Relación muchos-a-uno con Empleado.
     * Como en tu DB la FK se llama "idempleado",
     * necesitamos poner @JoinColumn(name="idempleado").
     */
    @ManyToOne
    @JoinColumn(name = "idempleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "idempleado_cierre")
    private Empleado empleadoCierre;

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

    public BigDecimal getMfinal() {
        return mfinal;
    }
    public void setMfinal(BigDecimal mfinal) {
        this.mfinal = mfinal;
    }

    public Integer getEstado() {
        return estado;
    }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getTpago() {
        return tpago;
    }

    public void setTpago(String tpago) {
        this.tpago = tpago;
    }

    public Empleado getEmpleadoCierre() {
        return empleadoCierre;
    }

    public void setEmpleadoCierre(Empleado empleadoCierre) {
        this.empleadoCierre = empleadoCierre;
    }
}