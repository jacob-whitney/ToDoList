import java.util.Scanner;

/**
 * Software Development II
 * September 7, 2025
 * Interface.java
 * @author Jacob Whitney
 */

public class Interface {
    // Attributes
    private ToDoList list;
    private static final Scanner sc = new Scanner(System.in);

    // Constructors
    public Interface() {
        list = new ToDoList();
        printStart();
    }

    // Custom Methods
    /**
     * printStart
     * Prints components of start page to console
     */
    public void printStart() {
        printHeader();
        list.printList();
        printMenuOptions();
        String input = sc.nextLine();
        getMenuActions(input);
    }

    /**
     * printHeader
     * Prints header for start page to console
     */
    public void printHeader() {
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("* - - - - - - - - - - - - - TO DO LIST - - - - - - - - - - - - - - *");
        System.out.println("********************************************************************");
    }
    /**
     * printMenuOptions
     * Prints interactive options for users
     */
    public void printMenuOptions() {
        System.out.print("Type 'a' to add an item, 'd' to delete, or 'q' to quit: ");
    }

    /**
     * getMenuActions
     * Using switch case, stores actions taken when a user chooses a menu option
     */
    public void getMenuActions(String input) {
        while (true) {
            switch (input) {
                case "a":
                    System.out.print("Describe your new to-do item: ");
                    String desc = sc.nextLine();
                    list.addItem(desc);
                    printStart();
                    break;
                case "d":
                    if ( list.getSize() > 0 ) {
                        System.out.print("Enter the ID of the to-do item to delete: ");
                        String id = sc.nextLine();
                        int intId = 0;
                        try {
                            intId = Integer.parseInt(id);
                        } catch (NumberFormatException e) {
                            System.out.println("> Not a valid ID");
                            printStart();
                            break;
                        }

                        if (!list.deleteItem(intId)) {
                            System.out.println("> Item not found");
                        }
                        printStart();
                        break;
                    } else {
                        System.out.println("> To-do list is empty, no items to delete");
                        printStart();
                        break;
                    }

                case "q":
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("> Invalid input, please try again");
                    printStart();
                    break;
            }
        }
    }
}
