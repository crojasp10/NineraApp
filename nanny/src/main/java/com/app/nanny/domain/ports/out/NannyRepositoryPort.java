package com.app.nanny.domain.ports.out;

import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.models.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NannyRepositoryPort {

    NannyCar save(NannyCar nanny);

    Optional <NannyCar> findById(Long id);

    List<NannyCar> findAll();

    Optional<NannyCar> update(NannyCar nannyCar, Long id);

    boolean deleteById(Long id);

    Page<NannyCar> findAll(Pageable pageable);
}
