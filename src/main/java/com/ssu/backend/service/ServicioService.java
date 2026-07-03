package com.ssu.backend.service;

import com.ssu.backend.entity.Servicio;
import com.ssu.backend.repository.ServicioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }

    public List<Servicio> listar() {
        return repository.findAll();
    }

    public Optional<Servicio> buscar(Long id) {
        return repository.findById(id);
    }

    public Servicio guardar(Servicio servicio) {
        return repository.save(servicio);
    }

    public Servicio actualizar(Long id, Servicio servicio) {

        Optional<Servicio> existe = repository.findById(id);

        if (existe.isPresent()) {

            Servicio s = existe.get();

            s.setNombre(servicio.getNombre());
            s.setDescripcion(servicio.getDescripcion());
            s.setIcono(servicio.getIcono());
            s.setEstado(servicio.getEstado());

            return repository.save(s);
        }

        return null;
    }

    public boolean eliminar(Long id) {

        Optional<Servicio> existe = repository.findById(id);

        if (existe.isPresent()) {

            repository.deleteById(id);

            return true;
        }

        return false;
    }

}