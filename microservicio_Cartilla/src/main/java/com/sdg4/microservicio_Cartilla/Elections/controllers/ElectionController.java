package com.sdg4.microservicio_Cartilla.Elections.controllers;


import com.sdg4.microservicio_Cartilla.Elections.models.entities.Election;
import com.sdg4.microservicio_Cartilla.Elections.services.ElectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eleccion")
public class ElectionController {
    @Autowired
    private ElectionServices electionServices;

    //ADMIN O USUARIO - retorna todas las elecciones
    @GetMapping
    public ResponseEntity<List<Election>> getAll() {
        List<Election> list =  electionServices.getAll();
        return ResponseEntity.ok(list);
    }

    //ADMIN O USUARIO  - retorna la eleccion por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Election>> getElectionById(@PathVariable Integer id) {
        Optional<Election> election = electionServices.getElectionById(id);
        return ResponseEntity.ok(election);
    }

    //ADMIN-Crear eleccion
    @PostMapping
    public ResponseEntity<Election> createElection(@RequestBody Election election) {
        Election createdElection = electionServices.createElection(election);
        return ResponseEntity.ok(createdElection);
    }
    //ADMIN-Actualizar eleccion
    @PutMapping
    public ResponseEntity<Election> updateElection(@RequestBody Election election) {
        Election updatedElection = electionServices.updateElection(election);
        return ResponseEntity.ok(updatedElection);
    }
    //ADMIN-Eliminar eleccion
    @DeleteMapping("/{id}")
    public void deleteElection(@PathVariable("id") Integer id) {
        electionServices.deleteElection(id);
    }
}
