package com.app.nanny.application.usecases;

import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.ports.in.CreateNannyUseCase;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;


public class CreateNannyCarUseCaseImpl implements CreateNannyUseCase {

    private final NannyRepositoryPort nannyRepositoryPort;

    public CreateNannyCarUseCaseImpl(NannyRepositoryPort nannyRepositoryPort) {
        this.nannyRepositoryPort = nannyRepositoryPort;
    }

    @Override
    public NannyCar createNanny(NannyCar nanny) {
        return nannyRepositoryPort.save(nanny);
    }
}
