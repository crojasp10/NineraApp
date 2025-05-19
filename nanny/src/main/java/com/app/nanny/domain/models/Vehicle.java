package com.app.nanny.domain.models;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    String fuel_type;
    String make;
    String model;
    String transmission;

}
