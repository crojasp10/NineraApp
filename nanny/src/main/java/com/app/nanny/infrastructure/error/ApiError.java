package com.app.nanny.infrastructure.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ApiError {

    private String error;
    private String message;
    private String details;

}
