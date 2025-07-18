package com.kubocode.ParkingClubEscritura.controller;

import com.kubocode.ParkingClubEscritura.dto.ModalSucursalMovilDTO;
import com.kubocode.ParkingClubEscritura.entity.Sucursal;
import com.kubocode.ParkingClubEscritura.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    // 🔹 Crear una nueva sucursal
    @PostMapping
    public ResponseEntity<Sucursal> crear(@RequestBody Sucursal sucursal) {
        return sucursalService.crear(sucursal)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    // 🔹 Actualizar una sucursal
    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizar(@PathVariable Long id, @RequestBody Sucursal detalles) {
        return sucursalService.actualizar(id, detalles)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Eliminar una sucursal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return sucursalService.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
