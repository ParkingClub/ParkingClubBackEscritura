package com.kubocode.ParkingClubEscritura.repository;

import com.kubocode.ParkingClubEscritura.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByEstado(Integer estado);

    Optional<Ticket> findByPlacaAndEstado(String placa, Integer estado);

    // Nuevo método: Filtrar por estado y por sucursal (a través del empleado)
    List<Ticket> findByEstadoAndEmpleado_Sucursal_Id(Integer estado, Long sucursalId);

    //obtener hora entrada por placa estado y idSucursal
    Optional<Ticket> findByPlacaAndEstadoAndEmpleadoSucursalId(
            String placa, Integer estado, Long idSucursal);

    List<Ticket> findByEstadoAndEmpleado_Sucursal_IdAndHsalidaBetween(
            Integer estado, Long sucursalId, LocalDateTime desde, LocalDateTime hasta);


}