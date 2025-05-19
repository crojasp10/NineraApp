package com.app.nanny.domain.models;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String address;
    private String pickUpCity;
    private String deliveryCity;


}
