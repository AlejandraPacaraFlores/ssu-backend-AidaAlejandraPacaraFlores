package com.ssu.backend.service;

import com.ssu.backend.entity.Convocatoria;
import com.ssu.backend.repository.ConvocatoriaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvocatoriaService {

    private final ConvocatoriaRepository repository;

    public ConvocatoriaService(ConvocatoriaRepository repository) {
        this.repository = repository;
    }

    public List<Convocatoria> listar() {
        return repository.findAll();
    }

    public Optional<Convocatoria> buscar(Long id) {
        return repository.findById(id);
    }

    public Convocatoria guardar(Convocatoria convocatoria) {
        return repository.save(convocatoria);
    }

    public Convocatoria actualizar(Long id, Convocatoria convocatoria) {

        Optional<Convocatoria> existe = repository.findById(id);

        if (existe.isPresent()) {

            Convocatoria c = existe.get();

            c.setTitulo(convocatoria.getTitulo());
            c.setDescripcion(convocatoria.getDescripcion());
            c.setFecha(convocatoria.getFecha());
            c.setArchivo(convocatoria.getArchivo());
            c.setEstado(convocatoria.getEstado());

            return repository.save(c);
        }

        return null;
    }

    public boolean eliminar(Long id) {

        Optional<Convocatoria> existe = repository.findById(id);

        if (existe.isPresent()) {

            repository.deleteById(id);

            return true;
        }

        return false;
    }

}