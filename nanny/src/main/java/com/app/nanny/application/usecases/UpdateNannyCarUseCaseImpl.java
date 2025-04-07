package com.app.nanny.application.usecases;

import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.ports.in.UpdateNannyUseCase;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;

import java.util.Optional;

public class UpdateNannyCarUseCaseImpl implements UpdateNannyUseCase {


    private final NannyRepositoryPort nannyRepositoryPort;

    public UpdateNannyCarUseCaseImpl(NannyRepositoryPort nannyRepositoryPort) {
        this.nannyRepositoryPort = nannyRepositoryPort;
    }

    @Override
    public Optional<NannyCar> updateNanny(Long id, NannyCar nanny) {
        return nannyRepositoryPort.update(nanny, id);
    }
}
