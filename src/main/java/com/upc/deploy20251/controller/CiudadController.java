package com.upc.deploy20251.controller;

import com.upc.deploy20251.dto.CiudadDTO;
import com.upc.deploy20251.dto.MensajeDTO;
import com.upc.deploy20251.model.Ciudad;
import com.upc.deploy20251.repository.CiudadRepository;
import com.upc.deploy20251.service.CiudadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ciudad")
public class CiudadController {
    final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }
    @GetMapping
    public ResponseEntity<List<CiudadDTO>> listar() {
        return ResponseEntity.ok(ciudadService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CiudadDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ciudadService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Ciudad> guardar(@RequestBody CiudadDTO ciudadDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.guardar(ciudadDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO> eliminar(@PathVariable Long id) {
        MensajeDTO mensajeDTO = new MensajeDTO();
        mensajeDTO.setMensaje(ciudadService.eliminar(id));

        return ResponseEntity.ok(mensajeDTO);
    }
}
