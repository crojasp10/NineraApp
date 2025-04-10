package com.app.nanny.application.usecases;

import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.ports.in.RetrieveNannyUseCase;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveNannyCarUseCaseImpl implements RetrieveNannyUseCase {

    private final NannyRepositoryPort nannyRepositoryPort;

    public RetrieveNannyCarUseCaseImpl(NannyRepositoryPort nannyRepositoryPort) {
        this.nannyRepositoryPort = nannyRepositoryPort;
    }

    @Override
    public Optional<NannyCar> getNanny(Long id) {
        return nannyRepositoryPort.findById(id);
    }

    @Override
    public List<NannyCar> getAllNanny() {
        return nannyRepositoryPort.findAll();
    }
}
