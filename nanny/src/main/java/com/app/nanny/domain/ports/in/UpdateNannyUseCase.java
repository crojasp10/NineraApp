package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.Nanny;
import java.util.Optional;


public interface UpdateNannyUseCase {

    Optional<Nanny> updateNanny(Long id, Nanny nanny);


}
