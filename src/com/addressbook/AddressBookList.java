package com.addressbook;

public class AddressBookList {



        private String bookName;

    public AddressBookList(String bookName) {

            this.bookName = bookName;
        }

        public String getbookName () {

            return bookName;
        }

        public void setbookName (String bookName){

            this.bookName = bookName;
        }

        public String toString () {
            return "Address Book Name: " + bookName;
        }
    }

