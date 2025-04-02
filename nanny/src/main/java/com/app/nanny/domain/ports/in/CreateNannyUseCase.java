package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.Nanny;

public interface CreateNannyUseCase {

    Nanny createNanny(Nanny nanny);



}
