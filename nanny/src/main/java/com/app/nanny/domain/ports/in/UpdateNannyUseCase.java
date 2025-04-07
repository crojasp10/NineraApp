package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.NannyCar;

import java.util.Optional;


public interface UpdateNannyUseCase {

   Optional<NannyCar> updateNanny(Long id, NannyCar nanny);

}
