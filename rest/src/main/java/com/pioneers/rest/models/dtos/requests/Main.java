package com.pioneers.rest.models.dtos.requests;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Africa", "Arab Republic of Egypt", "Cairo",
                "New Cairo", 11835, "Alzobair bn alawam", 15, 1, 1);

        System.out.println(address);

        System.out.println("address.getCountry() = " + address.getCountry());
        System.out.println("address.getGovernance() = " + address.getGovernance());
        System.out.println("address.getCity() = " + address.getCity());
        System.out.println("address.getZip() = " + address.getZip());
        System.out.println("address.getStreet() = " + address.getStreet());
        System.out.println("address.getBuildingNumber() = " + address.getBuildingNumber());
        System.out.println("address.getFloor() = " + address.getFloor());
        System.out.println("address.getApartmentNumber() = " + address.getApartmentNumber());
    }
}
