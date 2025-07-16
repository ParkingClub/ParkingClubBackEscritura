package com.kubocode.ParkingClubEscritura.repository;

import com.kubocode.ParkingClubEscritura.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}