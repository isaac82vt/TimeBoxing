/**
 * 
 */
package timeBoxing;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * @author Isaac Brumbley
 * 
 * This class tests the Task object
 *
 */
public class TaskTest extends TestCase {

    private Task task;
    
    /**
     * This constructor sets up the test class for Task object
     */
    public void setUp() {
        
        task = new Task("Physics HW", 7, 2.0);
    }
    
    /**
     * 
     */
    public void testGetImportance() {
        assertEquals(7, task.getImportance());
    }
    
    /**
     * 
     */
    public void testGetDescription() {
        assertEquals("Physics HW", task.getDescription());
    }
    
    /**
     * 
     */
    public void testGetTimeNeeded() {
        assertEquals(2.0, task.getTimeNeeded(), 0.1);
    }
    
    /**
     * 
     */
    public void testEquals() {
        
        //check if object is null
        assertFalse(task.equals(null));
        
        // check if object signature is same
        assertTrue(task.equals(task));
        
        // check if classes are not same
        assertFalse(task.equals(new Object()));
        
        // check if Description is different
        Task taskDescr = new Task("Physics Test", 7, 2.0);
        assertFalse(task.equals(taskDescr));
        
        //check if importance is different
        Task taskImp = new Task("Physics HW", 6, 2.0);
        assertFalse(task.equals(taskImp));
        
        // check if time is different
        Task taskTime = new Task("Physics HW", 7, 1.0);
        assertFalse(task.equals(taskTime));        

        //check if all are the same
        Task taskSame = new Task("Physics HW", 7, 2.0);
        assertTrue(task.equals(taskSame));   
    }
    
    /**
     * 
     */
    public void testCompareTime() {
        
        Task taskComp = new Task("Physics Lab", 5, 1.0);
        
        assertEquals(taskComp.compareTime(task), -1, 0.1);
        assertEquals(task.compareTime(taskComp), 1, 0.1);
        assertEquals(task.compareTime(task), 0, 0.1);
        
        Exception exception = null;
        try
        {
            task.compareTime(null);
            fail("CompareImportance() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("compareTime is throwing the wrong exception",
                   exception instanceof NullPointerException);
        
    }
    
    /**
     * 
     */
    public void testCompareImportance() {
        
        Task taskComp = new Task("Physics Lab", 2, 5.0); 
        
        assertEquals(taskComp.compareImportance(task), -5, 0.1);
        assertEquals(task.compareImportance(taskComp), 5, 0.1);
        assertEquals(task.compareImportance(task), 0, 0.1);
        
        Exception exception = null;
        try
        {
            task.compareImportance(null);
            fail("compareImportance() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("compareImportacne is throwing the wrong exception",
                   exception instanceof NullPointerException);
        
    }
    
}
