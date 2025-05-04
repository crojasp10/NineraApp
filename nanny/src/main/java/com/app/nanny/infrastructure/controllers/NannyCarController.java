package com.app.nanny.infrastructure.controllers;


import com.app.nanny.application.services.NannyCarService;
import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.infrastructure.error.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NannyCarController {

    private final NannyCarService nannyCarService;
    private static final Logger log = LoggerFactory.getLogger(NannyCarController .class);

    @PostMapping
    public ResponseEntity<NannyCar> createNanny(@RequestBody NannyCar request) {
        NannyCar nannyCar = NannyCar.builder().availablePlates(request.getAvailablePlates())
                .idDriver(request.getIdDriver()).idOwner(
                request.getIdOwner()).build();
//        NannyCar nanny = new NannyCar(request.getId(), request.getIdOwner(), request.getIdDriver(),request.getAvailablePlates());
        NannyCar created = nannyCarService.createNanny(nannyCar);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<NannyCar>> getAllNanny(){
        List<NannyCar> nannies = nannyCarService.getAllNanny();
        return ResponseEntity.ok(nannies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NannyCar> getNannyById(@PathVariable Long id){
        /*try{
            Optional<NannyCar> nanny = nannyCarService.getNanny(id);

            return nanny.map(ResponseEntity::ok)
                    .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(null));
        } catch(Exception e) {
            log.error("Error to get NannyCar by id {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }*/
        Optional<NannyCar> nanny = nannyCarService.getNanny(id);

        if(!nanny.isPresent()){
            throw  new ResourceNotFoundException("NannyCar not found id " + id);
        }
        return ResponseEntity.ok(nanny.get());


    }





}
