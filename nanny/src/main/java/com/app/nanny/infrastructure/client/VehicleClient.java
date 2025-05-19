package com.app.nanny.infrastructure.client;

import com.app.nanny.domain.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "carClient", url = "https://api.api-ninjas.com/v1")
public interface VehicleClient {

    @GetMapping("/cars")
    List<Vehicle> getCars(
            @RequestHeader("X-Api-Key") String apiKey,
            @RequestParam(value = "model", required = false) String model
    );


}