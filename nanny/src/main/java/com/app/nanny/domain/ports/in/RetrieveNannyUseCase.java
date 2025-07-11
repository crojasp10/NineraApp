package com.app.nanny.domain.ports.in;

import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.models.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RetrieveNannyUseCase {

    Optional<NannyCar> getNanny(Long id,String key, String model);
    List<NannyCar> getAllNanny();
    PageResponse<NannyCar> getAllNanny(Pageable pageable);

}
