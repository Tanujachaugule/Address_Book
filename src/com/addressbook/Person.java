package com.addressbook;

public class Person {
    public Person(String firstName, String lastName, String address, String city, String state, Integer zip, Long phone) {
    }

    public Person() {
        
    }

    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook");

        Person contactPerson = new Person();
    }

    public void setPhone(Long newPhone) {
    }

    public void setZip(Integer newZip) {
    }

    public void setState(String newState) {
    }

    public void setCity(String newCity) {
    }

    public void setAddress(String newAddress) {
    }
}