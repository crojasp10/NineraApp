package com.app.nanny.domain.ports.out;

import com.app.nanny.domain.models.NannyCar;

import java.util.List;
import java.util.Optional;


public interface NannyRepositoryPort {

    NannyCar save(NannyCar nanny);

    Optional <NannyCar> findById(Long id);

    List<NannyCar> findAll();

    Optional<NannyCar> update(NannyCar nannyCar, Long id);

    boolean deleteById(Long id);
}
