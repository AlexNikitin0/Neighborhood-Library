package com.pluralsight;
import java.util.Scanner;
import java.util.Arrays;
public class Library {

    public static void main(String[] args) {
        //instantiate Book obj
        Book[] books = new Book[20];
        Scanner keyboard = new Scanner(System.in);
        //load 20 books on it
        books[0] = new Book(1, "12345", "Cooking for dummies", false, "");
        books[1] = new Book(2, "12346", "Harry Pot Head", false, "");
        books[2] = new Book(3, "12347", "Intro to Java", false, "");
        books[3] = new Book(4, "12348", "Minecraft Guide to Redstone", false, "");
        books[4] = new Book(5, "12349", "48 Laws of Power", false, "");
        books[5] = new Book(6, "12351", "Wheels on the Bus", false, "");
        books[6] = new Book(7, "12352", "Journey to The Center of The Earth", false, "");
        books[7] = new Book(8, "12353", "Communist Manifesto", false, "");
        books[8] = new Book(9, "12354", "Veganism: Find a Cure", false, "");
        books[9] = new Book(10, "12355", "Think and Grow Rich", false, "");
        books[10] = new Book(11, "12356", "Genesis", false, "");
        books[11] = new Book(12, "12357", "12 rules for life", false, "");
        books[12] = new Book(13, "12358", "Notes From Underground", false, "");
        books[13] = new Book(14, "12359", "Cooking for Smarties", false, "");
        books[14] = new Book(15, "12360", "How to Tie Your Shoes: A Graphic Novel", false, "");
        books[15] = new Book(16, "12361", "Joe Biden Bed Time Stories", false, "");
        books[16] = new Book(17, "12362", "Do Not Read Please", false, "");
        books[17] = new Book(18, "12363", "Book 18", false, "");
        books[18] = new Book(19, "12364", "Using Your Brain: A Tutorial", false, "");
        books[19] = new Book(20, "12365", "Why is Waldo?", false, "");
        //declare variables
        int choice;
        int checkout;
        int checkOutID = 0;
        int checkOrBack;
        String userName = "";
        int checkOutIDCurrent;
        do {  //display menu
            System.out.println("Please select from the options Below:");
            System.out.println();
            System.out.println("1.) Show Available Books");
            System.out.println("2.) Show Checked Out Books");
            System.out.println("3.) Exit");
            choice = keyboard.nextInt();

            //decision structure

            if (choice == 1) { //main if

                for (int i = 0; i < books.length; i++) {

                    if (!books[i].getIsCheckedOut()) {
                        System.out.println(books[i].getTitle() + " ID: " + books[i].getId() + " ISBN: " + books[i].getIsbn());
                        System.out.println();


                    }


                }

                do {
                    System.out.println("Would you like to check out a book?");
                    System.out.println("(1) -Yes");
                    System.out.println("(2) -No");
                    System.out.print("Type 1 or 2: ");
                    checkout = keyboard.nextInt();

                    if (checkout == 1) {

                        System.out.println("Please enter the ID of the book you wish to check out: ");
                        //loop through books not checked out then get user input for book ID and username
                        for (int j = 0; j < books.length; j++) {

                            if (!books[j].getIsCheckedOut()) {
                                System.out.println(books[j].getTitle() + " ID: " + books[j].getId() + " ISBN: " + books[j].getIsbn());


                            }
                        }

                        System.out.print("Enter Book ID: ");
                        checkOutID = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.print("Please enter your name: ");
                        userName = keyboard.nextLine();

                        for (int k = 0; k < books.length; k++) {
                            if (books[k].getId() == checkOutID) {
                                books[k].checkOut(userName);
                            }

                        }//end k loop

                    } else if (checkout == 2) {

                    }
                } while (checkout != 2);


            } else if (choice == 2) {//main if 2: show checked out books
                System.out.println("Books currently checked out: ");
                for (int l = 0; l < books.length; l++) {
                    if (books[l].getIsCheckedOut()) {

                        System.out.println(books[l].getTitle() + " ID: " + books[l].getId() + " ISBN: " + books[l].getIsbn() + "Owner Name: " + books[l].getCheckedOutTo());
                        System.out.println();
                        System.out.println("(1) CHECK IN A BOOK");
                        System.out.println("(2) GO BACK TO HOME SCREEN");
                        checkOrBack = keyboard.nextInt();

                        if (checkOrBack == 1) {
                            System.out.print("Enter the ID of the Book you wish to check in: ");
                            checkOutIDCurrent = keyboard.nextInt();
                            for (int m = 0; m < books.length; m++) {
                                if (books[m].getId() == checkOutIDCurrent) {
                                    books[m].checkIn();
                                }

                            }

                        }
                    }//end l for
                }
                }
            else if (choice == 3) {
                    System.exit(0);
                }


            } while (choice != 3) ;


        }
    }

