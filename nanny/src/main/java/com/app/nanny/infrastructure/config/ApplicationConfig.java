package com.app.nanny.infrastructure.config;


import com.app.nanny.application.services.NannyCarService;
import com.app.nanny.application.usecases.*;
import com.app.nanny.domain.ports.in.GetLocationUseCase;
import com.app.nanny.domain.ports.out.NannyRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public NannyCarService nannyCarService(NannyRepositoryPort nannyRepositoryPort, GetLocationUseCase getLocationUseCase){

        return new NannyCarService(
                new CreateNannyCarUseCaseImpl(nannyRepositoryPort),
                new UpdateNannyCarUseCaseImpl(nannyRepositoryPort),
                new RetrieveNannyCarUseCaseImpl(nannyRepositoryPort),
                new DeleteNannyCarUseCaseImpl(nannyRepositoryPort),
                getLocationUseCase
        );







    }




}
