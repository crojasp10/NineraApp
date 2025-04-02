package com.app.nanny.domain.ports.out;

import com.app.nanny.domain.models.Nanny;

import java.util.List;
import java.util.Optional;

public interface NannyRepositoryPort {


    Nanny save(Nanny nanny);

    Optional<Nanny> findById(Long id);

    List<Nanny> findAll();

    Optional<Nanny> update();

    boolean deleteById(Long id);
}
