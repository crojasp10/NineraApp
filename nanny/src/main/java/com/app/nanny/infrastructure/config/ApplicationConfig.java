package com.app.nanny.infrastructure.config;


import com.app.nanny.application.services.NannyCarService;
import com.app.nanny.application.usecases.*;
import com.app.nanny.domain.ports.in.GetLocationUseCase;
import com.app.nanny.domain.ports.out.ExternalServicePort;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;
import com.app.nanny.infrastructure.client.VehicleClient;
import com.app.nanny.infrastructure.repositories.JpaNannyCarRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public NannyCarService nannyCarService(NannyRepositoryPort nannyRepositoryPort, GetLocationUseCase getLocationUseCase, LocationConfig locationConfig,VehicleClient vehicleClient){


        return new NannyCarService(
                new CreateNannyCarUseCaseImpl(nannyRepositoryPort),
                new UpdateNannyCarUseCaseImpl(nannyRepositoryPort),
                new RetrieveNannyCarUseCaseImpl(nannyRepositoryPort, locationConfig, vehicleClient),
                new DeleteNannyCarUseCaseImpl(nannyRepositoryPort),
                getLocationUseCase
        );
    }

    @Bean
    public NannyRepositoryPort nannyRepositoryPort(JpaNannyCarRepositoryAdapter jpaNannyCarRepositoryAdapter)   {

        return jpaNannyCarRepositoryAdapter;
    }

    @Bean
    public GetLocationUseCase getLocationUseCase(ExternalServicePort externalServicePort) {

        return new GetLocationUseCaseImpl(externalServicePort);

    }


}
