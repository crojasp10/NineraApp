package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.Location;

public interface GetLocationUseCase {

    Location getLocation (Long id);

}
