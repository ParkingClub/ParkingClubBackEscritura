package com.kubocode.ParkingClubEscritura.repository;

import com.kubocode.ParkingClubEscritura.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}