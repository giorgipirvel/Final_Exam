package oop.finalexam.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * ListManagement class implements a list processing algorithm that combines
 * elements from two input lists to create a result list.
 *
 * <p>The algorithm works as follows:
 * <ul>
 * <li>Takes two input lists: list1 (integers) and list2 (strings)</li>
 * <li>For each element at index i in list1, uses that element's value as an index
 *     to access list2</li>
 * <li>Combines the string from list2 with the integer from list1 to create
 *     the result element</li>
 * <li>Handles error cases where the integer value exceeds the bounds of list2</li>
 * </ul>
 *
 * <p>Error Handling:
 * When an integer value from list1 is greater than or equal to the size of list2,
 * the algorithm skips that element and continues processing the remaining elements.
 *
 * @author Your Name
 * @version 1.0
 */
public class ListManagement {

    /**
     * The first input list containing integer values that serve as indices
     */
    private List<Integer> list1;

    /**
     * The second input list containing string values to be accessed by indices
     */
    private List<String> list2;

    /**
     * The result list containing combined string and integer values
     */
    private List<String> list3;

    /**
     * Constructor initializes the ListManagement object with predefined values
     * as specified in the animation.
     */
    public ListManagement() {
        initializeLists();
    }

    /**
     * Initializes the input lists with predefined values exactly as shown
     * in the animation.
     */
    private void initializeLists() {
        // Initialize list1 with integer values
        list1 = new ArrayList<>();
        list1.add(6);  // index 0
        list1.add(3);  // index 1
        list1.add(8);  // index 2
        list1.add(7);  // index 3
        list1.add(10); // index 4
        list1.add(5);  // index 5
        list1.add(9);  // index 6
        list1.add(1);  // index 7
        list1.add(2);  // index 8
        list1.add(4);  // index 9

        // Initialize list2 with string values (corrected based on expected output)
        list2 = new ArrayList<>();
        list2.add("miq"); // index 0
        list2.add("cnn"); // index 1 (from expected result position 7: cnn1)
        list2.add("dcn"); // index 2 (from expected result position 8: dcn2)
        list2.add("dfw"); // index 3 (from expected result position 1: dfw3)
        list2.add("cac"); // index 4 (from expected result position 9: cac4)
        list2.add("oxx"); // index 5 (from expected result position 5: oxx5)
        list2.add("bwt"); // index 6 (from expected result position 0: bwt6)
        list2.add("feu"); // index 7 (from expected result position 3: feu7)
        list2.add("kpm"); // index 8 (from expected result position 2: kpm8)
        list2.add("zby"); // index 9 (from expected result position 6: zby9)
        list2.add("wfk"); // index 10 (from expected result position 4: wfk10)
        list2.add("pgt"); // index 11

        // Initialize result list
        list3 = new ArrayList<>();
    }

    /**
     * Processes the input lists according to the algorithm and populates the result list.
     *
     * <p>Algorithm Details:
     * <ol>
     * <li>Iterates through each element in list1</li>
     * <li>Uses the integer value as an index to access list2</li>
     * <li>Combines the accessed string with the integer value</li>
     * <li>Adds the combined result to list3</li>
     * </ol>
     *
     * <p>Error Handling:
     * If an integer value from list1 is greater than or equal to list2.size(),
     * the method prints an error message and skips that element.
     */
    public void processLists() {
        System.out.println("Starting list processing...");
        System.out.println("list1 size: " + list1.size());
        System.out.println("list2 size: " + list2.size());
        System.out.println();

        for (int i = 0; i < list1.size(); i++) {
            int index = list1.get(i);

            // Error handling: check if index is within bounds of list2
            if (index >= list2.size()) {
                System.err.println("Error: Index " + index + " at position " + i +
                        " is out of bounds for list2 (size: " + list2.size() + ")");
                System.err.println("Skipping element at position " + i);
                continue; // Skip this element and continue with next
            }

            // Correct algorithm: For each position i, use list1[i] as index to get list2[list1[i]]
            // Then combine list2[list1[i]] + list1[i]
            String stringFromList2 = list2.get(index);
            String element = stringFromList2 + index;
            list3.add(element);

            System.out.println("Position " + i + ": list1[" + i + "] = " + index +
                    " -> list2[" + index + "] = \"" + stringFromList2 +
                    "\" -> result: \"" + element + "\"");
        }

        System.out.println("\nProcessing completed!");
    }

    /**
     * Displays the contents of all three lists in a formatted manner.
     */
    public void displayLists() {
        System.out.println("\n=== LIST CONTENTS ===");

        // Display list1
        System.out.println("list1 (Integers):");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("  " + i + ": " + list1.get(i));
        }

        // Display list2
        System.out.println("\nlist2 (Strings):");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("  " + i + ": " + list2.get(i));
        }

        // Display list3
        System.out.println("\nlist3 (Result):");
        for (int i = 0; i < list3.size(); i++) {
            System.out.println("  " + i + ": " + list3.get(i));
        }
    }

    /**
     * Demonstrates error handling by creating a scenario with values that exceed
     * the bounds of list2.
     */
    public void demonstrateErrorHandling() {
        System.out.println("\n=== DEMONSTRATING ERROR HANDLING ===");

        // Create a test scenario with big values
        List<Integer> testList1 = new ArrayList<>();
        testList1.add(5);  // Valid index
        testList1.add(15); // Invalid index (exceeds list2 size)
        testList1.add(3);  // Valid index
        testList1.add(20); // Invalid index (exceeds list2 size)

        List<String> testResult = new ArrayList<>();

        System.out.println("Test list1 with big values: " + testList1);
        System.out.println("list2 size: " + list2.size());
        System.out.println();

        for (int i = 0; i < testList1.size(); i++) {
            int index = testList1.get(i);

            if (index >= list2.size()) {
                System.err.println("ERROR: Index " + index + " at position " + i +
                        " exceeds list2 size (" + list2.size() + ")");
                System.err.println("Skipping this element...");
            } else {
                String element = list2.get(index) + index;
                testResult.add(element);
                System.out.println("Valid: position " + i + " -> " + element);
            }
        }

        System.out.println("\nTest result: " + testResult);
    }

    /**
     * Main method to run the list management program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        ListManagement manager = new ListManagement();

        // Display initial lists
        manager.displayLists();

        // Process the lists
        manager.processLists();

        // Display final results
        manager.displayLists();

        // Demonstrate error handling
        manager.demonstrateErrorHandling();
    }
}