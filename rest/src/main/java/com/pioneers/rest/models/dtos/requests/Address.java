package com.pioneers.rest.models.dtos.requests;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor/*(access = AccessLevel.PRIVATE)*/
public class Address {
    private String continent;
    private String country;
    private String governance;
    private String city;
    private int zip;
    private String street;
    private int buildingNumber;
    private int floor;
    private int apartmentNumber;
}
