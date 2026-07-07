package com.ssu.backend.service;

import com.ssu.backend.entity.Reserva;
import com.ssu.backend.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public Optional<Reserva> buscar(Long id) {
        return repository.findById(id);
    }

    public Reserva guardar(Reserva reserva) {
        return repository.save(reserva);
    }

    public Reserva actualizar(Long id, Reserva reserva) {
        return repository.findById(id).map(existente -> {
            existente.setCodigoAsegurado(reserva.getCodigoAsegurado());
            existente.setContrasenia(reserva.getContrasenia());
            existente.setEspecialidad(reserva.getEspecialidad());
            existente.setFechaReserva(reserva.getFechaReserva());
            existente.setHoraReserva(reserva.getHoraReserva());
            existente.setEstado(reserva.getEstado());
            return repository.save(existente);
        }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}