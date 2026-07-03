package com.ssu.backend.controller;

import com.ssu.backend.entity.Servicio;
import com.ssu.backend.service.ServicioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin("*")
public class ServicioController {

    private final ServicioService service;

    public ServicioController(ServicioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servicio> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscar(@PathVariable Long id) {

        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody Servicio servicio) {

        return ResponseEntity.ok(service.guardar(servicio));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizar(
            @PathVariable Long id,
            @RequestBody Servicio servicio) {

        Servicio actualizado = service.actualizar(id, servicio);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        boolean eliminado = service.eliminar(id);

        if (eliminado) {
            return ResponseEntity.ok("Servicio eliminado correctamente.");
        }

        return ResponseEntity.notFound().build();

    }

}