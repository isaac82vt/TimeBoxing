package timeBoxing;
import org.junit.Test;
import static org.junit.Assert.*;

public class LListTest {

    @Test
    public void testAdd() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Test the size of the list after adding elements
        assertEquals(3, list.size());

        // Test if the list is empty after adding elements
        assertFalse(list.isEmpty());

        // Test if the elements were added to the end of the list
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void testAddAtIndex() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(0, 0);

        // Test the size of the list after adding an element at a specific index
        assertEquals(3, list.size());

        // Test if the list is empty after adding an element at a specific index
        assertFalse(list.isEmpty());

        // Test if the element was added at the correct index
        assertEquals(0, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
        assertEquals(2, (int) list.get(2));

        // Test if adding an element at an index greater than the size of the list adds it to the end
        list.add(4, 5);
        assertEquals(4, list.size());
        assertEquals(2, (int) list.get(2));

        // Test if adding an element at a negative index does not modify the list
        //list.add(-1, 6);
        //assertEquals(4, list.size());
    }

    @Test
    public void testRemove() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Test removing an element from the list
        assertTrue(list.remove(1));
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
        assertEquals(1, (int) list.get(0));
        assertEquals(3, (int) list.get(1));

        // Test removing an element that is not in the list
        assertFalse(list.remove(4));
        assertEquals(2, list.size());

        // Test removing an element from an empty list
        //LList<Integer> emptyList = new LList<>();
        //assertFalse(emptyList.remove(1));
        //assertEquals(0, emptyList.size());
    }

    @Test
    public void testGet() {
        LList<Integer> list = new LList<>();
        list.add(1);
        assertEquals(1, (int)list.get(0));
    }
    
    @Test
    public void testClear() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(1));
        assertFalse(list.contains(4));
    }

    @Test
    public void testIndexOf() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(0, list.lastIndexOf(1));
        assertEquals(-1, list.lastIndexOf(4));
    }

    @Test
    public void testLastIndexOf() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(1);

        assertEquals(2, list.lastIndexOf(1));
        assertEquals(-1, list.lastIndexOf(4));
    }

    @Test
    public void testRemoveAtIndex() {
        LList<Integer> list = new LList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(3, (int) list.get(1));
    }
}


