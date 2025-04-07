package com.app.nanny.application.usecases;

import com.app.nanny.domain.ports.in.DeleteNannyUseCase;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;

public class DeleteNannyCarUseCaseImpl implements DeleteNannyUseCase {

    private final NannyRepositoryPort nannyRepositoryPort;

    public DeleteNannyCarUseCaseImpl(NannyRepositoryPort nannyRepositoryPort) {
        this.nannyRepositoryPort = nannyRepositoryPort;
    }

    @Override
    public boolean deleteNanny(Long id) {
        return nannyRepositoryPort.deleteById(id);
    }
}
