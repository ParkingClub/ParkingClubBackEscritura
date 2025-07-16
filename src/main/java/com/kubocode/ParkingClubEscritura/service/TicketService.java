package com.kubocode.ParkingClubEscritura.service;

import com.kubocode.ParkingClubEscritura.dto.TicketRecaudacionDTO;
import com.kubocode.ParkingClubEscritura.entity.Empleado;
import com.kubocode.ParkingClubEscritura.entity.Ticket;
import com.kubocode.ParkingClubEscritura.repository.EmpleadoRepository;
import com.kubocode.ParkingClubEscritura.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Ticket createTicket(Ticket ticket) {

        ticket.setHentrada(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado con id: " + id));
    }


    public Optional<Ticket> buscarPorPlacaYEstado0ConValidacion(String placa) {
        return ticketRepository.findByPlacaAndEstado(placa, 0);
    }


    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket existingTicket = getTicketById(id);

        // Actualizar placa
        if (ticketDetails.getPlaca() != null) {
            existingTicket.setPlaca(ticketDetails.getPlaca());
        }

        // Actualizar hora de entrada
        if (ticketDetails.getHentrada() != null) {
            existingTicket.setHentrada(ticketDetails.getHentrada());
        }

        // Actualizar hora de salida
        if (ticketDetails.getHsalida() != null) {
            existingTicket.setHsalida(ticketDetails.getHsalida());
        }

        // Actualizar monto final
        if (ticketDetails.getMfinal() != null) {
            existingTicket.setMfinal(ticketDetails.getMfinal());
        }

        // Actualizar tipo de pago
        if (ticketDetails.getTpago() != null) {
            existingTicket.setTpago(ticketDetails.getTpago());
        }

        // Actualizar estado
        if (ticketDetails.getEstado() != null) {
            existingTicket.setEstado(ticketDetails.getEstado());
        }

        // Actualizar empleado que abrió (si procede)
        if (ticketDetails.getEmpleado() != null) {
            existingTicket.setEmpleado(ticketDetails.getEmpleado());
        }

        // Actualizar empleado de cierre
        // (sólo si se está recibiendo explícitamente, o si el estado cambió a 1, etc.)
        if (ticketDetails.getEmpleadoCierre() != null) {
            existingTicket.setEmpleadoCierre(ticketDetails.getEmpleadoCierre());
        }

        return ticketRepository.save(existingTicket);
    }



    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> getTicketsByEstadoAndSucursal(Integer estado, Long sucursalId) {
        return ticketRepository.findByEstadoAndEmpleado_Sucursal_Id(estado, sucursalId);
    }

    //Metodo para traer todos los datos de ticket(recaudaciones para rol admin) en base a la sucursal
    public List<TicketRecaudacionDTO> getTicketsrecaudacion(Integer estado,Long sucursalId){
        List<Ticket> listaTickets=ticketRepository.findByEstadoAndEmpleado_Sucursal_Id(estado, sucursalId);
        List<TicketRecaudacionDTO> listaTicketsRecaudacion=new ArrayList<>();
        for(Ticket ticket:listaTickets){
            TicketRecaudacionDTO ticketRecaudacionDTO=new TicketRecaudacionDTO();
            ticketRecaudacionDTO.setId(ticket.getId());
            ticketRecaudacionDTO.setPlaca(ticket.getPlaca());
            ticketRecaudacionDTO.setHentrada(ticket.getHentrada());
            ticketRecaudacionDTO.setHsalida(ticket.getHsalida());
            ticketRecaudacionDTO.setMonto(ticket.getMfinal());
            ticketRecaudacionDTO.setTipo_pago(ticket.getTpago());

            Empleado empleadoCierre=ticket.getEmpleadoCierre();
            if(empleadoCierre!=null){
                ticketRecaudacionDTO.setEmpleado_cierre(empleadoCierre.getNombre());
            }else{
                ticketRecaudacionDTO.setEmpleado_cierre("N/A");
            }
            listaTicketsRecaudacion.add(ticketRecaudacionDTO);
        }
        return listaTicketsRecaudacion;
    }

//Metodo para Obtener los tickets procesados filtrados por estado, sucursal y un rango de fechas basado en el periodo indicado.
    public List<TicketRecaudacionDTO> getTicketsPorPeriodo(Integer estado, Long sucursalId, String periodo) {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime desde;
        LocalDateTime hasta = ahora;

        switch (periodo.toLowerCase()) {
            case "hoy":
                desde = ahora.toLocalDate().atStartOfDay();
                break;
            case "ayer":
                desde = ahora.minusDays(1).toLocalDate().atStartOfDay();
                hasta = desde.plusDays(1);
                break;
            case "semana":
                desde = ahora.minusDays(7).toLocalDate().atStartOfDay();
                break;
            default:
                throw new IllegalArgumentException("Periodo inválido. Usa 'hoy', 'ayer' o 'semana'.");
        }

        List<Ticket> tickets = ticketRepository
                .findByEstadoAndEmpleado_Sucursal_IdAndHsalidaBetween(estado, sucursalId, desde, hasta);

        List<TicketRecaudacionDTO> resultado = new ArrayList<>();
        for (Ticket t : tickets) {
            TicketRecaudacionDTO dto = new TicketRecaudacionDTO();
            dto.setId(t.getId());
            dto.setPlaca(t.getPlaca());
            dto.setHentrada(t.getHentrada());
            dto.setHsalida(t.getHsalida());
            dto.setMonto(t.getMfinal());
            dto.setTipo_pago(t.getTpago());
            dto.setEmpleado_cierre(t.getEmpleadoCierre() != null ? t.getEmpleadoCierre().getNombre() : "N/A");
            resultado.add(dto);
        }
        return resultado;
    }


}