package com.kubocode.ParkingClubEscritura.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "idempresa", nullable = false)
    private Empresa empresa;

    @Column(nullable = false)
    private BigDecimal preciotarifa;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,8)")
    private BigDecimal latitud;

    @Column(nullable = false, columnDefinition = "DECIMAL(11,8)")
    private BigDecimal longitud;

    @Column(nullable = false)
    private Long estado;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int plazas;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = true) // Nullable explícito
    private String descripcion;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SucursalFotografia> fotografias;

    //Horario de Atencion
    @Column(name = "hora_apertura", nullable = true)
    private LocalTime horaApertura;

    @Column(name = "hora_cierre", nullable = true)
    private LocalTime horaCierre;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }

    public BigDecimal getPreciotarifa() { return preciotarifa; }
    public void setPreciotarifa(BigDecimal preciotarifa) { this.preciotarifa = preciotarifa; }

    public BigDecimal getLatitud() { return latitud; }
    public void setLatitud(BigDecimal latitud) { this.latitud = latitud; }

    public BigDecimal getLongitud() { return longitud; }
    public void setLongitud(BigDecimal longitud) { this.longitud = longitud; }

    public Long getEstado() { return estado; }
    public void setEstado(Long estado) { this.estado = estado; }

    public int getPlazas() { return plazas; }
    public void setPlazas(int plazas) { this.plazas = plazas; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<SucursalFotografia> getFotografias() { return fotografias; }
    public void setFotografias(List<SucursalFotografia> fotografias) { this.fotografias = fotografias; }

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