package com.kubocode.ParkingClubEscritura.util;

import java.util.Arrays;
import java.util.List;

public enum Role {
    USERS(Arrays.asList(Permission.UPDATE_TICKETS)),
    ADMIN(Arrays.asList(Permission.SELECT_UPDATE_SUCURSALES)),
    DEVELOPER(Arrays.asList(Permission.CREATE_SUCURSALES,Permission.SELECT_UPDATE_SUCURSALES,Permission.UPDATE_TICKETS));
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
