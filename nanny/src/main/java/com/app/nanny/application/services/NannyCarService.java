package com.app.nanny.application.services;

import com.app.nanny.domain.models.Location;
import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class NannyCarService implements CreateNannyUseCase, UpdateNannyUseCase, DeleteNannyUseCase, RetrieveNannyUseCase, GetLocationUseCase {

    private final CreateNannyUseCase createNannyUseCase;
    private final UpdateNannyUseCase updateNannyUseCase;
    private final RetrieveNannyUseCase retrieveNannyUseCase;
    private final DeleteNannyUseCase deleteNannyUseCase;
    private final GetLocationUseCase getLocationUseCase;


    public NannyCarService(CreateNannyUseCase createNannyUseCase, UpdateNannyUseCase updateNannyUseCase, RetrieveNannyUseCase retrieveNannyUseCase, DeleteNannyUseCase deleteNannyUseCase, GetLocationUseCase getLocationUseCase) {
        this.createNannyUseCase = createNannyUseCase;
        this.updateNannyUseCase = updateNannyUseCase;
        this.retrieveNannyUseCase = retrieveNannyUseCase;
        this.deleteNannyUseCase = deleteNannyUseCase;
        this.getLocationUseCase = getLocationUseCase;
    }

    @Override
    public NannyCar createNanny(NannyCar nanny) {
        return createNannyUseCase.createNanny(nanny);
    }

    @Override
    public boolean deleteNanny(Long id) {
        return deleteNannyUseCase.deleteNanny(id);
    }

    @Override
    public Optional<NannyCar> updateNanny(Long id, NannyCar nanny) {
        return updateNannyUseCase.updateNanny(id,nanny);
    }

    @Override
    public NannyCar getNanny(Long id) {
        return retrieveNannyUseCase.getNanny(id);
    }

    @Override
    public List<NannyCar> getAllNanny() {
        return retrieveNannyUseCase.getAllNanny();
    }


    @Override
    public Location getLocation(Long id) {
        return getLocationUseCase.getLocation(id);
    }
}
