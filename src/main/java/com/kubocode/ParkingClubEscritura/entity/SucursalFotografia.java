package com.kubocode.ParkingClubEscritura.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "sucursal_fotografias")
public class SucursalFotografia { //Esta entity se crea para almacenar las fotografias de sucursal relacion 1 a muchos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    @JsonBackReference
    private Sucursal sucursal;

    @Column(name = "fotografia", length = 255, nullable = true) // Nullable explícito
    private String fotografia;

    // Constructores
    public SucursalFotografia() {}

    public SucursalFotografia(Sucursal sucursal, String fotografia) {
        this.sucursal = sucursal;
        this.fotografia = fotografia;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Sucursal getSucursal() { return sucursal; }
    public void setSucursal(Sucursal sucursal) { this.sucursal = sucursal; }

    public String getFotografia() { return fotografia; }
    public void setFotografia(String fotografia) { this.fotografia = fotografia; }
}