package com.addressbook;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class FileIO1 {
    Scanner sc = new Scanner(System.in);
    ArrayList<Person> personInfo = new ArrayList<Person>();
    ArrayList<AddressBookList> addressbooklist = new ArrayList<AddressBookList>();

    public void newAddressBook() {

        System.out.println("Enter AddressBook Name");
        String bookName = sc.next();
        AddressBookList address = new AddressBookList(bookName);

        addressbooklist.add(address);
        System.out.println(addressbooklist.toString());
    }

    public void openAddressBook() {

        displayAddressBook();
        System.out.println("Enter name to Open  AddressBook");
        String bookName = sc.next();
        for (AddressBookList A : addressbooklist) {
            if (bookName.equals(A.getbookName())) {
                System.out.println("Address Book " + A.getbookName() + " is opened ");
            }
        }
    }

    public void displayAddressBook() {

        System.out.println("Display List of all AddressBook");
        for (int i = 0; i < addressbooklist.size(); i++) {
            System.out.println(addressbooklist.get(i));
        }
    }

    public void searchPerson() {

        System.out.println("Enter name to check entry present or not");
        String firstName = sc.next();

        for(Person P : personInfo) {
            if (firstName.equals(P.getFirstName())) {
                System.out.println("Person already exists in the book");
            } else {
                System.out.println("Person not exists add data");
            }
        }
    }

    public  synchronized void addPerson() {

        System.out.println("Enter First Name");
        String firstName = sc.next();

        System.out.println("Enter Last Name");
        String lastName = sc.next();

        System.out.println("Enter City");
        String city = sc.next();

        System.out.println("Enter State");
        String state = sc.next();

        System.out.println("Enter phone Number");
        long phoneNumber = sc.nextLong();

        System.out.println("Enter Zip");
        int zip = sc.nextInt();

        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        String FILE_HEADER = "First Name,Last Name,City,State,Phone Number,Zip";
        FileWriter fileWriter = null;
        try {

            Person person = new Person(firstName, lastName, city, state, phoneNumber, zip );
            personInfo.add(person);

            fileWriter = new FileWriter("D:\\AddressBook.csv", true);
            fileWriter.append(FILE_HEADER);
            for(Person p : personInfo) {
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(person.getFirstName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(person.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((CharSequence) person.getCity());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((CharSequence) person.getState());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(person.getPhoneNumber()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(person.getZip()));
            }
            System.out.println("Write CSV successfully!");
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Flushing/closing error!");
                e.printStackTrace();
            }
        }
    }

    public void display() {

        try {
            List<String> lines = Files.readAllLines(Paths.get("D:\\Address.csv"));
            for(String line : lines) {
                line = line.replace("\"", "");
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("No data found");
            e.printStackTrace();
        }
    }

    public void editPerson() {

        System.out.println("Enter First Name to update Record");
        String firstName = sc.next();

        for ( int i=0; i< personInfo.size(); i++) {
            Person person = (Person)personInfo.get(i);
            if(firstName.equals(person.getFirstName())) {
                System.out.println("Select any option to edit ");
                System.out.println("1.Phone Number" + "\n2.Address" + "\n3.Quit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 :
                        System.out.println("Enter new Phone Number");
                        long phoneNumber = sc.nextLong();

                        person.setPhoneNumber(phoneNumber);
                        break;
                    case 2 :
                        System.out.println("Enter new City");
                        String city = sc.next();

                        System.out.println("Enter new State");
                        String state = sc.next();

                        System.out.println("Enter new Zip");
                        int zip = sc.nextInt();

                        person.setCity(city);
                        person.setState(state);
                        person.setZip(zip);
                        break;
                    case 3 :
                        System.exit(0);
                        break;
                    default :
                        System.out.println("Incorrect Choice");
                }
            }
        }
    }

    public void deletePerson() {
        System.out.println("Enter Last Name to delete its Entry");
        String lastName = sc.next();
        for ( int i=0; i< personInfo.size(); i++) {
            Person person = (Person)personInfo.get(i);
            if(lastName.equals(person.getLastName())) {
                System.out.println(personInfo.get(i));
                personInfo.remove(i);
                System.out.println("Record Deleted");
            }
        }
    }

    public void searchByCityOrState() {

        System.out.println("Enter City to Search Person");
        String City = sc.next();

        System.out.println("Enter State to Search Person");
        String State = sc.next();
        for (Person P : personInfo) {
            if (City.equals(P.getCity()) || State.equals(P.getState())) {
                System.out.println(City);
                System.out.println(State);
            }
        }
        personInfo.stream()
                .filter(personInfo -> personInfo.getCity().equals(City))
                .filter(personInfo -> personInfo.getState().equals(State))
                .forEach(personInfo1 -> System.out.println(personInfo1));
    }

    public void countByCity() {

        System.out.println(personInfo.stream().collect(Collectors.groupingBy((Person P) -> P.getCity())));
        System.out.println(personInfo.stream().collect(Collectors.groupingBy((Person P) -> P.getCity(),
                Collectors.counting())));
    }

    public void countByState() {

        System.out.println(personInfo.stream().collect(Collectors.groupingBy((Person P) -> P.getState())));
        System.out.println(personInfo.stream().collect(Collectors.groupingBy((Person P) -> P.getState(),
                Collectors.counting())));
    }

    public void sortContactListByFirstName() {

        for (Person P : personInfo) {
            System.out.println(P.getFirstName());
        }
        System.out.println("*********");

        personInfo.stream();
        personInfo.sort(Comparator.comparing(Person::getFirstName));
        personInfo.forEach((Person P) -> System.out.println(P.getFirstName() + " " + P.getLastName()));
    }

    public void sortContactListByCity() {

        for (Person P : personInfo) {
            System.out.println(P.getCity());
        }
        System.out.println("*********");

        personInfo.stream();
        personInfo.sort(Comparator.comparing(Person::getCity));
        personInfo.forEach((Person P) -> System.out.println(P.getFirstName() + " " + P.getLastName() + " " + P.getCity() + " " + P.getState() + " " + P.getPhoneNumber() + " " + P.getZip() ));
    }

    public void sortContactListByState() {

        for (Person P : personInfo) {
            System.out.println(P.getState());
        }
        System.out.println("*********");

        personInfo.stream();
        personInfo.sort(Comparator.comparing(Person::getState));
        personInfo.forEach((Person P) -> System.out.println(P.getFirstName() + " " + P.getLastName() + " " + P.getCity() + " " + P.getState() + " " + P.getPhoneNumber() + " " + P.getZip() ));
    }

    public void sortContactListByZip() {

        for (Person P : personInfo) {
            System.out.println(P.getZip());
        }
        System.out.println("*********");

        personInfo.stream();
        personInfo.sort(Comparator.comparing(Person::getZip));
        personInfo.forEach((Person P) -> System.out.println(P.getFirstName() + " " + P.getLastName() + " " + P.getCity() + " " + P.getState() + " " + P.getPhoneNumber() + " " + P.getZip() ));
    }


//    @Override
//    protected void finalize() {
//        sc.close();
//    }
}
