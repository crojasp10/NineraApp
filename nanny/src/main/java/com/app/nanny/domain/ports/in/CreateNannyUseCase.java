package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.NannyCar;

public interface CreateNannyUseCase {

    NannyCar createNanny(NannyCar nanny);


}
