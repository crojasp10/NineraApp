package com.app.nanny.domain.ports.out;

import com.app.nanny.domain.models.NannyCar;

import java.util.List;


public interface NannyRepositoryPort {

    NannyCar save(NannyCar nanny);

    NannyCar findById(Long id);

    List<NannyCar> findAll();

    NannyCar update();

    boolean deleteById(Long id);
}
