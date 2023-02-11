package com.addressbook;
import java.util.*;
public class AddressBookMain {
    public static void main(String[] args) {

        System.out.println("Welcome to AddressBook");

        Map<String, List<Object>> addressBook = new TreeMap<>();

        addPerson(addressBook);

    }


    public static Map<String, List<Object>> addPerson(Map<String, List<Object>> addressBook) {
        String firstName = null;
        String lastName = null;
        String address = null;
        String city = null;
        String state = null;
        Integer zip = null;
        String email = null;

        List<Object> Person = new ArrayList<>();
        Person.add(firstName);
        Person.add(lastName);
        Person.add(address);
        Person.add(city);
        Person.add(state);
        Person.add(zip);
        Person.add(email);

        String name = firstName + " " + lastName;

        addressBook.put(name, Person);

        return addressBook;

    }
}
