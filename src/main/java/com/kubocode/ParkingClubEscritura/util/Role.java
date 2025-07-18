package com.kubocode.ParkingClubEscritura.util;

import java.util.Arrays;
import java.util.List;

public enum Role {
    CUSTOMER(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    ADMINISTRATOR(Arrays.asList(Permission.SAVE_ONE_PRODUCT,Permission.READ_ALL_PRODUCTS)),
    USERS(Arrays.asList(Permission.READ_TICKETS,Permission.UPDATE_TICKETS,Permission.READ_EMPLEADOS,Permission.GET_PLAZAS,Permission.GET_TARIFAS_MONTO,Permission.GET_NOMBRE_UBICACION_SUCURSAL)),
    ADMIN(Arrays.asList(Permission.SELECT_UPDATE_SUCURSALES,Permission.ALL_EMPLEADOS,Permission.READ_TICKETS,Permission.READ_EMPLEADOS,Permission.GET_PLAZAS,Permission.GET_TARIFAS_MONTO,Permission.GET_NOMBRE_UBICACION_SUCURSAL,Permission.UPDATE_TICKETS)),
    DEVELOPER(Arrays.asList(Permission.ALL_EMPRESAS,Permission.CREATE_SUCURSALES,Permission.SELECT_UPDATE_SUCURSALES,Permission.ALL_EMPLEADOS,Permission.ALL_EMPLEADOS,Permission.UPDATE_TICKETS,Permission.READ_TICKETS,Permission.READ_EMPLEADOS,Permission.GET_PLAZAS,Permission.ALL_TARIFAS,Permission.GET_TARIFAS_MONTO,Permission.GET_NOMBRE_UBICACION_SUCURSAL));
    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}