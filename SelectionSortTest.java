package timeBoxing;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testSortByTime() {
        LList<Task> list = new LList<Task>();
        list.add(new Task("Task 1", 2, 1));
        list.add(new Task("Task 2", 1, 3));
        list.add(new Task("Task 3", 3, 4));
        
        //System.out.println(list.toString());
        
        SelectionSort.sortByTime(list);
        //System.out.println(list.toString());

        
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Task 3");
        expected.add("Task 2");
        expected.add("Task 1");
        
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected.get(i), list.get(i).getDescription());
        }
    }
    
    @Test
    public void testSortByImportance() {
        LList<Task> list = new LList<Task>();
        list.add(new Task("Task 1", 2, 1));
        list.add(new Task("Task 2", 1, 3));
        list.add(new Task("Task 3", 3, 4));
        
        //System.out.println(list.toString());
        
        SelectionSort.sortByImportance(list);
        //System.out.println(list.toString());

        
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Task 3");
        expected.add("Task 1");
        expected.add("Task 2");
        
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected.get(i), list.get(i).getDescription());
        }
    }
}
