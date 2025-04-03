package com.app.nanny.domain.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Location {

    private Double latitude;
    private Double longitude;
    private String address;
    private String pickUpCity;
    private String deliveryCity;


}
