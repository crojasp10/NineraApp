package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.Nanny;

import java.util.List;
import java.util.Optional;

public interface RetrieveNannyUseCase {

    Optional<Nanny> getNanny(Long id);
    List<Nanny> getAllNanny();

}
