package com.pioneers.designpatterns.builder;

import java.util.List;

public record Address(String continent, String country, String governance, String city, int zip, String street,
                      int buildingNumber, int floor, int apartmentNumber, boolean isActive, List<String> rooms) implements Cloneable {

    private Address(AddressBuilder builder) {
        this(builder.continent, builder.country, builder.governance, builder.city, builder.zip, builder.street,
                builder.buildingNumber, builder.floor, builder.apartmentNumber, builder.isActive, builder.rooms);
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private String continent;
        private String country;
        private String governance;
        private String city;
        private int zip;
        private String street;
        private int buildingNumber;
        private int floor;
        private int apartmentNumber;
        private boolean isActive;
        private List<String> rooms;

        public AddressBuilder continent(String continent) {
            this.continent = continent;
            return this;
        }

        public AddressBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AddressBuilder governance(String governance) {
            this.governance = governance;
            return this;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder zip(int zip) {
            this.zip = zip;
            return this;
        }

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder buildingNumber(int buildingNumber) {
            this.buildingNumber = buildingNumber;
            return this;
        }

        public AddressBuilder floor(int floor) {
            this.floor = floor;
            return this;
        }

        public AddressBuilder apartmentNumber(int apartmentNumber) {
            this.apartmentNumber = apartmentNumber;
            return this;
        }

        public AddressBuilder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public AddressBuilder rooms(List<String> rooms) {
            this.rooms = rooms;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
