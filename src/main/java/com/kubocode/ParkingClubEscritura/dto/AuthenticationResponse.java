package com.kubocode.ParkingClubEscritura.dto;

import com.kubocode.ParkingClubEscritura.util.Role;

public class AuthenticationResponse {

    private String jwt;
    private Long idEmpleado;
    private String nombreEmpleado;
    private String mac;
    private Long idsucursal;
    private Long idempresa;
    private Role role;

    public AuthenticationResponse(String jwt , Long idEmpleado, String nombreEmpleado,String mac,Long idsucursal,Long idempresa,Role role) {
        this.jwt = jwt;
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.mac=mac;
        this.idsucursal=idsucursal;
        this.idempresa=idempresa;
        this.role=role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Long getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Long idsucursal) {
        this.idsucursal = idsucursal;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }
}
