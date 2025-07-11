package com.app.nanny.application.usecases;

import com.app.nanny.domain.models.Location;
import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.models.Vehicle;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;
import com.app.nanny.infrastructure.client.VehicleClient;
import com.app.nanny.infrastructure.config.LocationConfig;
import com.app.nanny.infrastructure.repositories.JpaNannyCarRepository;
import com.app.nanny.infrastructure.repositories.JpaNannyCarRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class RetrieveNannyCarUseCaseImplTest {

    @Mock
    private VehicleClient vehicleClient;

    @Mock
    private JpaNannyCarRepositoryAdapter jpaNannyCarRepositoryAdapter;

    @Mock
    private NannyRepositoryPort nannyRepositoryPort;

    @Mock
    private JpaNannyCarRepository jpaNannyCarRepository;


    @Mock
    private LocationConfig locationConfig;

    @InjectMocks
    private RetrieveNannyCarUseCaseImpl retrieveNannyCarUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        retrieveNannyCarUseCase = new RetrieveNannyCarUseCaseImpl(nannyRepositoryPort, locationConfig, vehicleClient, jpaNannyCarRepository);
    }

    @Test
    void testGetNannySuccess() {
        Long id = 1L;
        String apiKey = "key";
        String model = "camry";

        NannyCar nanny = new NannyCar();
        nanny.setId(id);

        Location location = new Location();

        List<Vehicle> vehicles = Arrays.asList(Vehicle.builder().fuel_type("gas")
                .make("toyota").model("camry").transmission("a").build());

        when(nannyRepositoryPort.findById(id)).thenReturn(Optional.of(nanny));
        when(locationConfig.getLocationById(id)).thenReturn(location);
        when(vehicleClient.getCars(apiKey, model)).thenReturn(vehicles);

        Optional<NannyCar> result = retrieveNannyCarUseCase.getNanny(id, apiKey, model);

        assertTrue(result.isPresent());
        assertEquals("camry", result.get().getVehicles().get(0).getModel());
    }

    @Test
    void testGetNannyNotFound() {
        Long id = 99L;
        when(nannyRepositoryPort.findById(id)).thenReturn(Optional.empty());

        Optional<NannyCar> result = retrieveNannyCarUseCase.getNanny(id, "key", "model");

        assertFalse(result.isPresent());
    }

    @Test
    void testGetAllNanny() {
        NannyCar nanny1 = new NannyCar();
        nanny1.setId(1L);

        NannyCar nanny2 = new NannyCar();
        nanny2.setId(10L);

        List<NannyCar> nannies = Arrays.asList(nanny1, nanny2);

        when(nannyRepositoryPort.findAll()).thenReturn(nannies);
        when(locationConfig.getLocationById(anyLong())).thenReturn(new Location());
        when(vehicleClient.getCars(anyString(), anyString())).thenReturn(Arrays.asList(Vehicle.builder().fuel_type("gas")
                .make("toyota").model("Rio").transmission("a").build()));

        List<NannyCar> result = retrieveNannyCarUseCase.getAllNanny();

        assertEquals(2, result.size());
        assertNotNull(result.get(0).getVehicles());
        assertEquals("Rio", result.get(0).getVehicles().get(0).getModel());
    }

}