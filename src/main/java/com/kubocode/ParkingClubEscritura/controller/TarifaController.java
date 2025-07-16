package com.kubocode.ParkingClubEscritura.controller;

import com.kubocode.ParkingClubEscritura.entity.Tarifa;
import com.kubocode.ParkingClubEscritura.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
    @Autowired
    TarifaService tarifaService;

    @PostMapping("/crear")
    public String crearTarifa(@RequestBody Tarifa tarifa){
        tarifaService.guardarTarifa(tarifa);
        return "Tarifa creada exitosamente";
    }

    @PutMapping("/modificar/{id}")
    public void modificarTarifa(@PathVariable Long id,@RequestBody Tarifa tarifa){
        tarifaService.modificarTarifa(id,tarifa);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTarifa(@PathVariable Long id){
        tarifaService.eliminarTarifa(id);
    }

}
