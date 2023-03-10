package com.addressbook;
import java.util.*;
public class AddressBook {
    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Address Book Program");
        AddressBook addressbook = new AddressBook();

        int answer=1;
        while (answer == 1) {
            System.out.println("Select any option for Address Book Operation");
            System.out.println("1. Create New AddressBook"
                    + "\n2. open existing AddressBook"
                    + "\n3. Display AddressBook"
                    + "\n4. Quit");
            int choice =scanner.nextInt();

            switch(choice) {
                case 1 :
                    addressbook.newAddressBook();
                    break;
                case 2 :
                    addressbook.openAddressBook();

                    int input=1;
                    while (input == 1) {
                        System.out.println("Select any option From Menu ");
                        System.out.println("1. Check Person "
                                + "\n2. Add Person"
                                + "\n3. Edit Person"
                                + "\n4. Delete Person"
                                + "\n5. Display"
                                + "\n6. Search by city and state"
                                + "\n7. Count by City"
                                + "\n8. Count by State"
                                + "\n9. Quit");
                        int value = scanner.nextInt();

                        switch (value) {
                            case 1 :
                                addressbook.searchPerson();
                                break;
                            case 2 :
                                addressbook.addPerson();
                                break;
                            case 3 :
                                addressbook.editPerson();
                                break;
                            case 4 :
                                addressbook.deletePerson();
                                break;
                            case 5 :
                                addressbook.display();
                                break;
                            case 6 :
                                addressbook.searchByCityOrState();
                                break;
                            case 7 :
                                addressbook.countByCity();
                                break;
                            case 8 :
                                addressbook.countByState();
                                break;
                            case 9 :
                                input = 0;
                                break;
                            default :
                                System.out.println("Incorrect Choice" + "\nEnter a number between 1 and 8");
                        }
                    }
                    break;
                case 3 :
                    addressbook.displayAddressBook();
                    break;
                case 4 :
                    answer = 0;
                    break;
                default :
                    System.out.println("Enter a number between 1 and 3");
            }
        }
    }

    void openAddressBook() {
    }

    void newAddressBook() {
    }

    void searchPerson() {
    }

    void addPerson() {
    }

    void editPerson() {
    }

    void deletePerson() {
        
    }

    void display() {
    }

    void searchByCityOrState() {
    }

    void countByCity() {
    }

    void countByState() {
    }

    void displayAddressBook() {
    }

    public void sortContactListByCity() {
    }

    public void sortContactListByFirstName() {
    }

    public void sortContactListByState() {
    }

    public void sortContactListByZip() {
    }
}