package com.kubocode.ParkingClubEscritura.repository;

import com.kubocode.ParkingClubEscritura.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}