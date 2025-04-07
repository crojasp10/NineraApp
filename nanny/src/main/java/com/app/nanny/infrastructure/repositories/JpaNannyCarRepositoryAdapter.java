package com.app.nanny.infrastructure.repositories;

import com.app.nanny.application.mapper.NannyCarMapper;
import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;
import com.app.nanny.infrastructure.entities.NannyCarEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class JpaNannyCarRepositoryAdapter implements NannyRepositoryPort {


    private final JpaNannyCarRepository jpaNannyCarRepository;


    @Override
    public NannyCar save(NannyCar nanny) {
        NannyCarEntity nannyCarEntity = NannyCarMapper.INSTANCE.toEntity(nanny);
        NannyCarEntity savedNannyCarEntity = jpaNannyCarRepository.save(nannyCarEntity);
        return NannyCarMapper.INSTANCE.toModel(savedNannyCarEntity);
    }

    @Override
    public NannyCar findById(Long id) {
        return null;
    }

    @Override
    public List<NannyCar> findAll() {
        return null;
    }

    @Override
    public Optional<NannyCar> update(NannyCar nannyCar, Long id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
