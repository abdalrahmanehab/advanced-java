package com.pioneers.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        final Address address = new Address("Africa", "Arab Republic of Egypt", "Cairo",
//                "New Cairo", 11835, "Alzobair bn alawam", 15, 1, 1);

        final Address address = Address.builder()
                .continent("Africa")
                .country("Arab Republic of Egypt")
                .governance("Cairo")
                .city("New Cairo")
                .zip(11835)
                .street("Alzobair bn alawam")
                .buildingNumber(15)
                .build();

        final Address newAddress = Address.builder()
                .continent(address.continent())
                .country(address.country())
                .governance(address.governance())
                .city(address.city())
                .zip(address.zip())
                .street(address.street())
                .buildingNumber(address.buildingNumber())
                .floor(1)
                .apartmentNumber(1)
                .isActive(true)
                .rooms(List.of("Room1", "Room2"))
                .build();

        System.out.println(newAddress);

        System.out.println("address.getCountry() = " + address.country());
        System.out.println("address.getGovernance() = " + address.governance());
        System.out.println("address.getCity() = " + address.city());
        System.out.println("address.getZip() = " + address.zip());
        System.out.println("address.getStreet() = " + address.street());
        System.out.println("address.getBuildingNumber() = " + address.buildingNumber());
        System.out.println("address.getFloor() = " + address.floor());
        System.out.println("address.getApartmentNumber() = " + address.apartmentNumber());
        System.out.println("address.getIsActive() = " + address.isActive());
        System.out.println("address.getRooms() = " + address.rooms());
    }
}
