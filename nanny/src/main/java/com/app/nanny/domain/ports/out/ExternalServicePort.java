package com.app.nanny.domain.ports.out;

import com.app.nanny.domain.models.Location;

public interface ExternalServicePort {

    Location getNannyLocation (Long id);

}
