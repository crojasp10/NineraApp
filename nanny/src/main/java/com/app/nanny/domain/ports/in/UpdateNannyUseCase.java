package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.NannyCar;



public interface UpdateNannyUseCase {

    NannyCar updateNanny(Long id, NannyCar nanny);

}
