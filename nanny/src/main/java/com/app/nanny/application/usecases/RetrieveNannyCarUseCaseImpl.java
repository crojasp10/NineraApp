package com.app.nanny.application.usecases;

import com.app.nanny.domain.models.Location;
import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.domain.models.Vehicle;
import com.app.nanny.domain.ports.in.RetrieveNannyUseCase;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;
import com.app.nanny.infrastructure.client.VehicleClient;
import com.app.nanny.infrastructure.config.LocationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RetrieveNannyCarUseCaseImpl implements RetrieveNannyUseCase {

    private final NannyRepositoryPort nannyRepositoryPort;
    private final LocationConfig locationConfig;
    private final VehicleClient vehicleClient;
    private List<String> vehiclesModel = Arrays.asList("Corolla", "Camry", "vitara"
            , "explorer", "rio", "fiesta", "ranger");
    String apiKey = "t97F0Y8T3fiVKuzA5kygdQ==Yl67AFz0AbwLlZMh";

    private static final Logger log = LoggerFactory.getLogger(RetrieveNannyCarUseCaseImpl.class);


    public RetrieveNannyCarUseCaseImpl(NannyRepositoryPort nannyRepositoryPort, LocationConfig locationConfig, VehicleClient vehicleClient) {
        this.nannyRepositoryPort = nannyRepositoryPort;
        this.locationConfig = locationConfig;
        this.vehicleClient = vehicleClient;
    }

    @Override
    public Optional<NannyCar> getNanny(Long id,String key, String model) {

        try{
            return nannyRepositoryPort.findById(id).map(nannyCar -> {
                try{
                    Location location = locationConfig.getLocationById(id);
                    if(location != null){
                        location.setId(id);
                        nannyCar.setLocation(location);
                    }else{
                        log.warn("No location found for nanny with id {}", id);
                    }
                }catch (Exception e) {
                    log.error( "Error to obtain location for nannyCar with id: {}",id,e);
                }
                List<Vehicle> vehicleList = vehicleClient.getCars(key,model);
                nannyCar.setVehicles(vehicleList);
                return nannyCar;
            });
        }
        catch (Exception e){
                log.error("Error to obtain nannyCar with id: {}\",id,e");
                return Optional.empty();
        }
    }

    @Override
    public List<NannyCar> getAllNanny() {
       return  nannyRepositoryPort.findAll().stream()
                .map(nannyCar -> {
                    Location location = locationConfig.getLocationById(nannyCar.getId());
                    location.setId(nannyCar.getId());
                    nannyCar.setLocation(location);
                    String model = "";
                    model = nannyCar.getId() < vehiclesModel.size()?  vehiclesModel.get(Math.toIntExact(nannyCar.getId())): "camry";
                    List<Vehicle> vehicles = vehicleClient.getCars(apiKey, model);
                    nannyCar.setVehicles(vehicles);
                            return nannyCar;
                }).collect(Collectors.toList());
    }
}
