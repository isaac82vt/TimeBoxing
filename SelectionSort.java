package timeBoxing;

/**
 * SelectionSort class provides a method to sort a LinkedList using the Selection Sort algorithm.
 * <p>
 * Selection sort is an in-place comparison sort algorithm. It works by selecting the minimum element
 * from the unsorted portion of the list and swapping it with the first element of the unsorted portion.
 * This process is repeated for the remaining unsorted portion of the list until the entire list is sorted.
 * 
 * @param <T> type of elements in the list, must be comparable
 */
public class SelectionSort {

    /**
     * Sorts a LinkedList of Tasks by time using the Selection Sort algorithm.
     * 
     * @param list the list to be sorted
     */
    public static void sortByTime(LList<Task> list) {
        // outer loop to iterate through the list
        for (int i = 0; i < list.size() - 1; i++) {
            // variable to keep track of the minimum element's index
            int minIndex = i;
            // inner loop to find the minimum element in the unsorted portion of the list
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTime(list.get(minIndex)) > 0) {
                    minIndex = j;
                }
            }
            // check if the current element is not already the minimum element
            if (i != minIndex) {
                // swap the current element with the minimum element
                Task temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
    
    /**
     * Sorts a LinkedList of Tasks by importance using the Selection Sort algorithm.
     * 
     * @param list the list to be sorted
     */
    public static void sortByImportance(LList<Task> list) {
        // outer loop to iterate through the list
        for (int i = 0; i < list.size() - 1; i++) {
            // variable to keep track of the minimum element's index
            int minIndex = i;
            // inner loop to find the minimum element in the unsorted portion of the list
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareImportance(list.get(minIndex)) > 0) {
                    minIndex = j;
                }
            }
            // check if the current element is not already the minimum element
            if (i != minIndex) {
                // swap the current element with the minimum element
                Task temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}



