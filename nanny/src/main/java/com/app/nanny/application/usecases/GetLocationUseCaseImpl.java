package com.app.nanny.application.usecases;

import com.app.nanny.domain.models.Location;
import com.app.nanny.domain.ports.in.GetLocationUseCase;
import com.app.nanny.domain.ports.out.ExternalServicePort;

public class GetLocationUseCaseImpl implements GetLocationUseCase {

    private final ExternalServicePort externalServicePort;

    public GetLocationUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public Location getLocation(Long id) {
        return externalServicePort.getNannyLocation(id);
    }
}
