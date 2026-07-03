package com.ssu.backend.service;

import com.ssu.backend.entity.Noticia;
import com.ssu.backend.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    private final NoticiaRepository repository;

    public NoticiaService(NoticiaRepository repository) {
        this.repository = repository;
    }

    public List<Noticia> listar() {
        return repository.findAll();
    }

    public Optional<Noticia> buscar(Long id) {
        return repository.findById(id);
    }

    public Noticia guardar(Noticia noticia) {
        return repository.save(noticia);
    }

    public Noticia actualizar(Long id, Noticia noticia) {

        Optional<Noticia> existe = repository.findById(id);

        if (existe.isPresent()) {

            Noticia n = existe.get();

            n.setTitulo(noticia.getTitulo());
            n.setDescripcion(noticia.getDescripcion());
            n.setFecha(noticia.getFecha());
            n.setImagen(noticia.getImagen());
            n.setEstado(noticia.getEstado());

            return repository.save(n);

        }

        return null;

    }

    public boolean eliminar(Long id) {

        Optional<Noticia> existe = repository.findById(id);

        if (existe.isPresent()) {

            repository.deleteById(id);

            return true;

        }

        return false;

    }

}