package com.addressbook;

public class Person {
    public Person(String firstName, String lastName, String address, String city, String state, Integer zip, Long phone) {
    }

    public Person() {
        
    }

    public Person(String firstName, String lastName, String city, String state, long phoneNumber, int zip) {
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

    public String getFirstName() {
        return null;
    }

    public void setPhoneNumber(long phoneNumber) {
    }

    public String getLastName() {
        return null;
    }

    public Object getState() {
        return null;
    }

    public Object getCity() {
        return null;
    }

    public boolean getZip() {
        return false;
    }
}