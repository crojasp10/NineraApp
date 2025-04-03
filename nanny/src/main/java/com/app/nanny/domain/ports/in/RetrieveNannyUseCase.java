package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.NannyCar;

import java.util.List;

public interface RetrieveNannyUseCase {

    NannyCar getNanny(Long id);
    List<NannyCar> getAllNanny();

}
