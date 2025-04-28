package com.app.nanny.infrastructure.repositories;

import com.app.nanny.domain.models.Location;
import com.app.nanny.domain.ports.out.ExternalServicePort;
import org.springframework.stereotype.Service;

@Service
public class ExternalServiceAdapter implements ExternalServicePort {
    @Override
    public Location getNannyLocation(Long id) {
        return null;
    }
}
