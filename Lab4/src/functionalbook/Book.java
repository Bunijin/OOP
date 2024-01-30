package functionalbook;

import java.util.Scanner;

public class Book {

    public static void main(String[] args) {
        PageNavigator book = new PageNavigator();
        Scanner input = new Scanner(System.in);
        String userChoice;
        do {
            book.displayMenu();
            userChoice = input.nextLine();

            switch (userChoice) {
                case "1":
                    book.goToFirstPage();
                    System.out.println("Page turned to the first page.");
                    break;
                case "2":
                    book.goToLastPage();
                    System.out.println("Page turned to the last page.");
                    break;
                case "3":
                    System.out.print("Enter the page number: ");
                    int pageNumber = input.nextInt();
                    book.goToPage(pageNumber);
                    input.nextLine();
                    break;
                case "4":
                    book.goToBookmarkedPage();
                    System.out.println("Page turned to the bookmarked page.");
                    break;
                case "5":
                    book.goToNextPage();
                    break;
                case "6":
                    book.goToPreviousPage();
                    break;
                case "7":
                    book.bookmarkCurrentPage();
                    System.out.println("Page bookmarked.");
                    break;
                case "8":
                    System.out.println("Total Page Count: " + book.getTotalPageCount());
                    break;
                case "9":
                    System.out.println("Current Page Number: " + book.getCurrentPageIndex());
                    break;
                case "10":
                    System.out.println("Bookmarked Page Number: " + book.getBookmarkedPageIndex());
                    break;
                case "11":
                    System.out.println("Closing the book and exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 11.");
            }
        } while (!userChoice.equals("11"));
        input.close();
    }
}
