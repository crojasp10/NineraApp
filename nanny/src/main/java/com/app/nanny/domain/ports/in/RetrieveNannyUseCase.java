package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.NannyCar;

import java.util.List;
import java.util.Optional;

public interface RetrieveNannyUseCase {

    Optional<NannyCar> getNanny(Long id);
    List<NannyCar> getAllNanny();

}
