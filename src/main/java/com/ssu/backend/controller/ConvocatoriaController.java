package com.ssu.backend.controller;

import com.ssu.backend.entity.Convocatoria;
import com.ssu.backend.service.ConvocatoriaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/convocatorias")
@CrossOrigin("*")
public class ConvocatoriaController {

    private final ConvocatoriaService service;

    public ConvocatoriaController(ConvocatoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Convocatoria> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convocatoria> buscar(@PathVariable Long id) {

        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Convocatoria> guardar(@RequestBody Convocatoria convocatoria) {

        return ResponseEntity.ok(service.guardar(convocatoria));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Convocatoria> actualizar(
            @PathVariable Long id,
            @RequestBody Convocatoria convocatoria) {

        Convocatoria actualizada = service.actualizar(id, convocatoria);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        boolean eliminado = service.eliminar(id);

        if (eliminado) {
            return ResponseEntity.ok("Convocatoria eliminada correctamente.");
        }

        return ResponseEntity.notFound().build();

    }

}