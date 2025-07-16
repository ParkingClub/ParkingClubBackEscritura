package com.kubocode.ParkingClubEscritura.controller;

import com.kubocode.ParkingClubEscritura.entity.Empleado;
import com.kubocode.ParkingClubEscritura.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // 🔹 Crear un nuevo empleado
    @PostMapping
    public ResponseEntity<Empleado> crear(@RequestBody Empleado empleado) {
        return empleadoService.crear(empleado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    // 🔹 Actualizar un empleado
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Long id, @RequestBody Empleado detalles) {
        return empleadoService.actualizar(id, detalles)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return empleadoService.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}