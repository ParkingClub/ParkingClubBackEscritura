package com.kubocode.ParkingClubEscritura.service;

import com.kubocode.ParkingClubEscritura.dto.CabeceraTicketDTO;
import com.kubocode.ParkingClubEscritura.dto.SucursalMovilparaListaDTO;
import com.kubocode.ParkingClubEscritura.dto.UbicacionSucursalDTO;
import com.kubocode.ParkingClubEscritura.entity.Empresa;
import com.kubocode.ParkingClubEscritura.entity.Sucursal;
import com.kubocode.ParkingClubEscritura.repository.EmpresaRepository;
import com.kubocode.ParkingClubEscritura.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private EmpresaRepository empresaRepository;


    // Crear una nueva sucursal
    public Optional<Sucursal> crear(Sucursal sucursal) {
        if (sucursal.getEmpresa() == null || sucursal.getEmpresa().getId() == null) {
            return Optional.empty(); // Requiere una empresa válida
        }
        Optional<Empresa> empresaOpt = empresaRepository.findById(sucursal.getEmpresa().getId());
        if (empresaOpt.isEmpty()) {
            return Optional.empty();
        }
        sucursal.setId(null); // Hibernate generará el ID
        return Optional.of(sucursalRepository.save(sucursal));
    }

    // Actualizar una sucursal
    public Optional<Sucursal> actualizar(Long id, Sucursal detalles) {
        return sucursalRepository.findById(id).map(sucursal -> {
            sucursal.setNombre(detalles.getNombre());
            sucursal.setUbicacion(detalles.getUbicacion());
            sucursal.setPreciotarifa(detalles.getPreciotarifa());
            sucursal.setLatitud(detalles.getLatitud());
            sucursal.setLongitud(detalles.getLongitud());
            sucursal.setEstado(detalles.getEstado());
            sucursal.setPlazas(detalles.getPlazas());
            sucursal.setHoraApertura(detalles.getHoraApertura());
            sucursal.setHoraCierre(detalles.getHoraCierre());


            if (detalles.getEmpresa() != null && detalles.getEmpresa().getId() != null) {
                empresaRepository.findById(detalles.getEmpresa().getId()).ifPresent(sucursal::setEmpresa);
            }

            return sucursalRepository.save(sucursal);
        });
    }

    // Eliminar una sucursal
    public boolean eliminar(Long id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
