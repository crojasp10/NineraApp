package com.app.nanny.infrastructure.repositories;

import com.app.nanny.application.mapper.NannyCarMapper;
import com.app.nanny.application.mapper.PageMapper;
import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.models.PageResponse;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;
import com.app.nanny.infrastructure.entities.NannyCarEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
@Repository
public class JpaNannyCarRepositoryAdapter implements NannyRepositoryPort {

    private final NannyCarMapper mapper;
    private final JpaNannyCarRepository jpaNannyCarRepository;
    private final PageMapper pageMapper;


    @Override
    public NannyCar save(NannyCar nanny) {
        NannyCarEntity nannyCarEntity = mapper.toEntity(nanny);
        NannyCarEntity savedNannyCarEntity = jpaNannyCarRepository.save(nannyCarEntity);
        return mapper.toModel(savedNannyCarEntity);
    }

    @Override
    public Optional <NannyCar> findById(Long id) {
        return jpaNannyCarRepository.findById(id)
                .map(mapper::toModel);
    }

    @Override
    public List<NannyCar> findAll() {
        return jpaNannyCarRepository.findAll().stream().map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NannyCar> update(NannyCar nannyCar, Long id) {

        if(jpaNannyCarRepository.existsById(nannyCar.getId())){
            NannyCarEntity nannyCarEntity = mapper.toEntity(nannyCar);
            NannyCarEntity updatedNannyCarEntity = jpaNannyCarRepository.save(nannyCarEntity);
            return Optional.of(mapper.toModel(updatedNannyCarEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {

        if(jpaNannyCarRepository.existsById(id)) {
            jpaNannyCarRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<NannyCar> findAll(Pageable pageable) {


        return jpaNannyCarRepository
                .findAll(pageable)
                .map(mapper::toModel);


    }


}
