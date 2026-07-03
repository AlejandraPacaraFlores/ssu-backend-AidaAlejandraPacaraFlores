package com.ssu.backend.controller;

import com.ssu.backend.entity.Noticia;
import com.ssu.backend.service.NoticiaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
@CrossOrigin("*")
public class NoticiaController {

    private final NoticiaService service;

    public NoticiaController(NoticiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Noticia> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> buscar(@PathVariable Long id) {

        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Noticia> guardar(@RequestBody Noticia noticia) {

        return ResponseEntity.ok(service.guardar(noticia));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> actualizar(
            @PathVariable Long id,
            @RequestBody Noticia noticia) {

        Noticia actualizada = service.actualizar(id, noticia);

        if (actualizada == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(actualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        boolean eliminado = service.eliminar(id);

        if (eliminado) {

            return ResponseEntity.ok("Noticia eliminada correctamente.");

        }

        return ResponseEntity.notFound().build();

    }

}