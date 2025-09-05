/**
 * Software Development II
 * September 7, 2025
 * ToDoItem.java
 * @author Jacob Whitney
 */

public class ToDoItem {
    // Attributes
    private int id;
    private String description = "";

    // Constructor
    public ToDoItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Custom Methods
    /**
     * getItemRow
     * Returns string displaying a to-do list item's
     * ID number, checckbox for completion, and description
     */
    public String getItemRow() {
        StringBuilder row = new StringBuilder();

        row.append(String.valueOf(this.getId()));
        if (id <= 9) {
            row.append("     ");
        } else if (id > 9) {
            row.append("    ");
        } else if (id > 99) {
            row.append("   ");
        } else if (id > 999) {
            row.append("  ");
        } else if (id > 9999) {
            row.append(" ");
        }

        row.append(description);

        return row.toString();
    }


}
