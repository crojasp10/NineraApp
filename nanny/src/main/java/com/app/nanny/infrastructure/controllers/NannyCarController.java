package com.app.nanny.infrastructure.controllers;


import com.app.nanny.application.services.NannyCarService;
import com.app.nanny.domain.models.NannyCar;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NannyCarController {

    private final NannyCarService nannyCarService;

    @PostMapping
    public ResponseEntity<NannyCar> createNanny(@RequestBody NannyCar request) {
        NannyCar nanny = new NannyCar(request.getId(), request.getIdOwner(), request.getIdDriver(),request.getAvailablePlates());
        NannyCar created = nannyCarService.createNanny(nanny);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<NannyCar>> getAllNanny(){
        List<NannyCar> nannies = nannyCarService.getAllNanny();
        return ResponseEntity.ok(nannies);
    }







}
