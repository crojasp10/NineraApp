package com.app.nanny.domain.models;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NannyCar {

        private Long id;
        private String idOwner;
        private String idDriver;
        private Integer availablePlates;
        private Location location;


}
