package functionalbook;

public class PageNavigator {

    int totalPageCount = 20;
    int currentPageIndex = 1;
    int bookmarkedPageIndex = 0;

    void goToFirstPage() {
        currentPageIndex = 1;
    }

    void goToLastPage() {
        currentPageIndex = totalPageCount;
    }

    void goToPage(int pageIndex) {
        if (0 >= pageIndex || pageIndex > totalPageCount) {
            System.out.println("Cannot go to page" + pageIndex + "!");
        } else {
            currentPageIndex = pageIndex;
            System.out.println("Page turned to the specified page.");
        }
    }

    void goToBookmarkedPage() {
        currentPageIndex = bookmarkedPageIndex;
    }

    void goToNextPage() {
        if (currentPageIndex + 1 == totalPageCount) {
            System.out.println("This is the last page! Cannot turn to the Next Page!");
        } else {
            currentPageIndex++;
            System.out.println("Page turned to the next page.");
        }
    }

    void goToPreviousPage() {
        if (currentPageIndex - 1 == 0) {
            System.out.println("This is the first page! Cannot turn to the Previous Page!");
        } else {
            currentPageIndex--;
            System.out.println("Page turned to the previous page.");
        }
    }

    void bookmarkCurrentPage() {
        bookmarkedPageIndex = currentPageIndex;
    }

    int getTotalPageCount() {
        return totalPageCount;
    }

    int getCurrentPageIndex() {
        return currentPageIndex;
    }

    int getBookmarkedPageIndex() {
        return bookmarkedPageIndex;
    }

    void displayMenu() {
        System.out.println("==================================================");
        System.out.print("1. Go to First Page");
        System.out.print("       5. Go to Next Page");
        System.out.println("        9. Show Current Page Number");
        System.out.print("2. Go to Last Page");
        System.out.print("        6. Go to Previous Page");
        System.out.println("    10. Show Bookmarked Page Number");
        System.out.print("3. Go to a Specific Page");
        System.out.print("  7. Bookmark Current Page");
        System.out.println("  11. Close Book and Exit Program");
        System.out.print("4. Go to Bookmarked Page");
        System.out.println("  8. Show Total Page Count");
    }
}
