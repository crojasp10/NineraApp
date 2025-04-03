package com.app.nanny.domain.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NannyCar {

        private Long id;
        private String idOwner;
        private String idDriver;
        private Integer availablePlates;


}
