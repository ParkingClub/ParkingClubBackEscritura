package com.kubocode.ParkingClubEscritura.service;

import com.kubocode.ParkingClubEscritura.entity.Tarifa;

import java.util.List;

public interface ITarifaService {
    public void guardarTarifa(Tarifa tarifa);
    public Tarifa obtenerTarifaById(Long id);
    public void modificarTarifa(Long id,Tarifa tarifa);
    public void eliminarTarifa(Long id);
}
