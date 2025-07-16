package com.kubocode.ParkingClubEscritura.service;

import com.kubocode.ParkingClubEscritura.dto.TicketDetalleDTO;
import com.kubocode.ParkingClubEscritura.entity.Tarifa;
import com.kubocode.ParkingClubEscritura.entity.Ticket;
import com.kubocode.ParkingClubEscritura.repository.TarifaRepository;
import com.kubocode.ParkingClubEscritura.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class TarifaService implements ITarifaService {

    @Autowired
    TarifaRepository tarifaRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void guardarTarifa(Tarifa tarifa) {
        tarifaRepository.save(tarifa);
    }


    @Override
    public Tarifa obtenerTarifaById(Long id) {
        return tarifaRepository.findById(id).orElse(null);
    }

    @Override
    public void modificarTarifa(Long id,Tarifa tarifa) {
        Tarifa tarifaById=this.obtenerTarifaById(id);
        tarifaById.setId(id);
        tarifaById.setSucursal(tarifa.getSucursal());
        tarifaById.setTiempo(tarifa.getTiempo());
        tarifaById.setMontoTarifa(tarifa.getMontoTarifa());
        this.guardarTarifa(tarifaById);
    }

    @Override
    public void eliminarTarifa(Long id) {
        tarifaRepository.deleteById(id);
    }

    public BigDecimal calcularMonto(String placa, Long idSucursal){
        Ticket ticket = ticketRepository.findByPlacaAndEstadoAndEmpleadoSucursalId(placa, 0, idSucursal)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No hay ticket activo para la placa " + placa));
        long minutos = Duration.between(ticket.getHentrada(), LocalDateTime.now()).toMinutes();

        List<Tarifa> tarifas = tarifaRepository.findBySucursalId(idSucursal);
        tarifas.sort(Comparator.comparingInt(Tarifa::getTiempo));

        Tarifa tarifaAplicable = tarifas.stream()
                .filter(t -> minutos >= t.getTiempo())
                .reduce((first, second) -> second)
                .orElse(tarifas.get(0));
        return tarifaAplicable.getMontoTarifa();
    }


    public TicketDetalleDTO generarDetalleTicket(String placa, Long idSucursal) {
        // 1) Buscar el ticket activo
        Ticket ticket = ticketRepository.findByPlacaAndEstadoAndEmpleadoSucursalId(placa, 0, idSucursal)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No hay ticket activo para la placa " + placa));

        // 2) Calcular el monto a pagar usando la lógica existente
        BigDecimal monto = calcularMonto(placa, idSucursal);

        // 3) Crear el DTO y asignar valores
        TicketDetalleDTO dto = new TicketDetalleDTO();
        dto.setId(ticket.getId());
        dto.setPlaca(ticket.getPlaca());
        dto.setHentrada(ticket.getHentrada());
        // La "hora actual" la usas como hora de salida
        dto.setHsalida(LocalDateTime.now());
        dto.setMonto(monto);

        return dto;
    }
}
