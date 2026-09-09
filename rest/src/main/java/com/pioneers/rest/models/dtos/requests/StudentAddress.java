package com.pioneers.rest.models.dtos.requests;

import lombok.Data;
import lombok.ToString;

@Data
//@ToString(onlyExplicitlyIncluded = true)
//@ToString
//@ToString(of = {"country", "governance", "city"})
@ToString(exclude = {"continent", "apartmentNumber"})
public class StudentAddress {
//    @ToString.Exclude
    private String continent;
//    @ToString.Include
    private String country;
//    @ToString.Include
    private String governance;
//    @ToString.Include
    private String city;
    private int zip;
    private String street;
    private int buildingNumber;
//    @ToString.Exclude
    private int floor;
//    @ToString.Exclude
    private int apartmentNumber;
}
