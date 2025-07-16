package com.kubocode.ParkingClubEscritura.service;

import com.kubocode.ParkingClubEscritura.entity.Empleado;
import com.kubocode.ParkingClubEscritura.entity.Sucursal;
import com.kubocode.ParkingClubEscritura.repository.EmpleadoRepository;
import com.kubocode.ParkingClubEscritura.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    // Crear un nuevo empleado con contraseña encriptada
    public Optional<Empleado> crear(Empleado empleado) {
        if (empleado.getSucursal() == null || empleado.getSucursal().getId() == null) {
            return Optional.empty(); // La sucursal es obligatoria
        }
        Optional<Sucursal> sucursalOpt = sucursalRepository.findById(empleado.getSucursal().getId());
        if (sucursalOpt.isEmpty()) {
            return Optional.empty();
        }
        empleado.setContraseña(passwordEncoder.encode(empleado.getContraseña())); // Encriptar contraseña
        empleado.setSucursal(sucursalOpt.get());
        return Optional.of(empleadoRepository.save(empleado));
    }

    // Actualizar empleado (re-encripta la contraseña si se modifica)
    public Optional<Empleado> actualizar(Long id, Empleado detalles) {
        return empleadoRepository.findById(id).map(empleado -> {
            empleado.setUsuario(detalles.getUsuario());
            empleado.setNombre(detalles.getNombre());
            empleado.setCedula(detalles.getCedula());
            empleado.setCelular(detalles.getCelular());
            empleado.setEmail(detalles.getEmail());
            empleado.setRol(detalles.getRol());
            empleado.setEstado(detalles.getEstado());
            empleado.setFechaActualizacion(detalles.getFechaActualizacion());
            empleado.setMac(detalles.getMac());
            empleado.setSucursal(detalles.getSucursal());

            //Cambio para evitar contraseñas en blanco
            if (detalles.getContraseña() != null && !detalles.getContraseña().isBlank()) {
                empleado.setContraseña(passwordEncoder.encode(detalles.getContraseña()));
            }

            return empleadoRepository.save(empleado);
        });
    }

    // Eliminar un empleado
    public boolean eliminar(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}