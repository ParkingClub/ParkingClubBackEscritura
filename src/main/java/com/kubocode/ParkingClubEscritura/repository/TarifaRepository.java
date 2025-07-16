package com.kubocode.ParkingClubEscritura.repository;

import com.kubocode.ParkingClubEscritura.entity.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa,Long> {
    List<Tarifa> findBySucursalId(Long sucursalId);//Metodo para traer todas las tarifas de acuerdo a las sucursales
}
